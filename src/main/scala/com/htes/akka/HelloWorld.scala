package com.htes.akka

import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.actor.typed.{ActorRef, ActorSystem, Behavior}

object HelloWorld {
  final case class Greet(whom: String, replyTo: ActorRef[Greeted])
  final case class Greeted(whom: String, from: ActorRef[Greet])
  def apply(): Behavior[Greet] =
    Behaviors.receive { (context, message) =>
      context.log.info("Hello {}!", message.whom)
      message.replyTo ! Greeted(message.whom, context.self)
      Behaviors.same
    }
}

object HelloWorldBot {
  def apply(max: Int): Behavior[HelloWorld.Greeted] = bot(greetingCounter = 0, max)

  private def bot(greetingCounter: Int, max: Int): Behavior[HelloWorld.Greeted] =
    Behaviors.receive { (context, message) =>
      val n = greetingCounter + 1
      context.log.info("Greeting {} for {}", n, message.whom)
      if (n == max) {
        Behaviors.stopped
      } else {
        message.from ! HelloWorld.Greet(message.whom, context.self)
        bot(n, max)
      }
    }
}

object HelloWorldMain {
  final case class SayHello(name: String)
  def apply(): Behavior[SayHello] = Behaviors.setup { context =>
      val greeter = context.spawn(HelloWorld(), "greeter")
      Behaviors.receiveMessage { message =>
        val replyTo = context.spawn(HelloWorldBot(max = 1), s"replyTo-${message.name}")
        greeter ! HelloWorld.Greet(message.name, replyTo)
        Behaviors.same
      }
    }
}

object HelloWorldApp extends App {
  val system: ActorSystem[HelloWorldMain.SayHello] = ActorSystem(HelloWorldMain(), "hello-world")

  system ! HelloWorldMain.SayHello("World")
}
