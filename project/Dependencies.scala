import sbt._

object Dependencies {
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http"   % "10.1.1"
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.5.12"
  lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.5.12"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
}
