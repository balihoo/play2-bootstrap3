//From https://github.com/spray/twirl/issues/15#issuecomment-32272389
resolvers += Classpaths.sbtPluginSnapshots

//Is this the same as the add below?
//Classpaths.sbtPluginReleases
//resolvers ++= Seq(
//  "sbt-plugin-releases" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"
//)

addSbtPlugin("io.spray" %% "sbt-twirl" % "0.7.0-SNAPSHOT" )



