
ThisBuild / scalaVersion := "3.3.3"

val catsVersion       = "2.12.0"
val catsEffectVersion = "3.5.4"
val http4sVersion     = "0.23.27"

lazy val root = (project in file("."))
  .settings(
    name := "Samples",
    Compile / run / fork := true,
    Compile / run / javaOptions += "-Dcats.effect.warnOnNonMainThreadDetected=false",
    libraryDependencies ++= Seq(
      // Core Functional Frameworks
      "org.typelevel" %% "cats-core"   % catsVersion,
      "org.typelevel" %% "cats-effect" % catsEffectVersion,

      // Http4s Client & Server (Built on Cats Effect)
      "org.http4s" %% "http4s-ember-server" % http4sVersion,
      "org.http4s" %% "http4s-ember-client" % http4sVersion,
      "org.http4s" %% "http4s-dsl"          % http4sVersion,

      // Functional Logging Bridges
      "org.typelevel"  %% "log4cats-slf4j"  % "2.7.0",
      "ch.qos.logback" % "logback-classic"  % "1.5.6",

      // You can add library dependencies here, for example,
      // "org.scalatest" %% "scalatest" % "3.2.19" % Test,
      // "org.scalameta" %% "munit" % "1.2.3" % Test
      "org.apache.pekko" %% "pekko-actor-typed" % "1.1.3"
    )
  )
