import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "ejemplo",
    libraryDependencies ++= Seq(
      akkaHttp,
      akkaActor,
      akkaStream,
      scalaTest % Test,
      "de.heikoseeberger"                %% "akka-log4j"                           % "1.4.0",
      "de.heikoseeberger"                %% "akka-http-circe"                      % "1.18.1",
      "io.circe"                         %% "circe-core"                           % "0.8.0",
      "io.circe"                         %% "circe-generic"                        % "0.8.0",
      "io.circe"                         %% "circe-parser"                         % "0.8.0"
    )
  )
