organization := "com.balihoo"

name := "play2-bootstrap3"

//this should be kept in sync with the play version
version := "2.2.1-SNAPSHOT"


seq(Twirl.settings: _*)


resolvers ++= Seq(
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.2.1",
  //Testing
  //"junit" % "junit" % "4.11" % "test",
  "org.specs2" %% "specs2" % "2.1.1" % "test",
  "org.mockito" % "mockito-core" % "1.9.5" % "test"
)


//Artifact Publishing Stuff, stolen from http://www.scala-sbt.org/0.13.0/docs/Community/Using-Sonatype.html
//Not releasing to Maven Central...so cheating
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", System.getenv("sonatypeuser"), System.getenv(" sonatypepassword"))