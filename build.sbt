
name := """pdfgen-scala-play-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(DockerPlugin)

libraryDependencies ++= Seq(
    jdbc,
    ws,
    "com.google.inject" % "guice" % "5.0.1",
    "com.hhandoko" %% "play26-scala-pdf" % "4.3.0"
)

// Docker Stuff
Docker / maintainer := "bernd.huber@johner-institut.de"
Docker / packageName := "pdfgen-scala-play-example"
Docker / version := sys.env.getOrElse("BUILD_NUMBER", "0")
Docker / daemonUserUid  := None
Docker / daemonUser := "daemon"
dockerExposedPorts := Seq(9000)
dockerBaseImage := "openjdk:8"
dockerRepository := sys.env.get("ecr_repo")
dockerUpdateLatest := true

// Tune Settings of Docker-Stuff
javaOptions in Universal ++= Seq(
    // JVM memory tuning
    "-J-Xmx2048m",
    "-J-Xms512m",

    // alternative, you can remove the PID file
    s"-Dpidfile.path=/dev/null",

    // Use separate configuration file for production environment
    s"-Dconfig.file=/opt/docker/conf/application.conf",

    // Use separate logger configuration file for production environment
    s"-Dlogger.file=/opt/docker/conf/logback.xml"
)