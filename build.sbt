lazy val root = (project in file("."))
  .settings(
    name := "HelloWorld",
    version := "1.0",
    scalaVersion := "2.11.12"
)

libraryDependencies ++= {
    Seq(
        "com.typesafe.play" %% "play-json" % "2.3.10"
    )
}

lazy val hello = taskKey[Unit]("An example task")
