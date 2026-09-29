package com.htes.http4s

import cats.effect._
import com.comcast.ip4s._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import scala.concurrent.duration._

object Http4sExample extends IOApp {

  // 1. Define Routes using the Http4s DSL
  val helloWorldRoutes: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name!")

    case GET -> Root / "ping" =>
      Ok("pong")
  }

  // 2. Build the Server Resource
  val serverResource = EmberServerBuilder
    .default[IO]
    .withHost(ipv4"127.0.0.1")
    .withPort(port"8080")
    .withHttpApp(helloWorldRoutes.orNotFound) // Fallback to 404 if route doesn't match
    .build

  // 3. Build the Client Resource
  val clientResource = EmberClientBuilder.default[IO].build

  // 4. Orchestrate both in the IOApp entry point
  override def run(args: List[String]): IO[ExitCode] = {
    val resources = for {
      // Start the server and client concurrently within a Resource block
      _      <- serverResource
      client <- clientResource
    } yield client

    resources.use { client =>
      // Construct a target URI and request payload
      val targetUri = uri"http://127.0.0.1:8080/hello/world"

      for {
        // Execute the request and unpack the text body
        response <- client.expect[String](targetUri)
        _        <- IO.println(s"Client received response: $response")
        _        <- IO.sleep(5000.seconds)
      } yield ExitCode.Success
    }
  }
}
