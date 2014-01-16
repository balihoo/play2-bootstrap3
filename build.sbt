organization := "com.balihoo"

name := "play2-bootstrap3"

//this should be kept in sync with the play version
version := "2.2.1"


seq(Twirl.settings: _*)


resolvers ++= Seq(
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.2.1",
  //Testing
  "junit" % "junit" % "4.11" % "test",
  "org.specs2" %% "specs2" % "2.1.1" % "test",
  "org.mockito" % "mockito-core" % "1.9.5" % "test"
)