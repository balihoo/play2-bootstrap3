master [![Build Status](https://travis-ci.org/balihoo/play2-bootstrap3.png?branch=master)](https://travis-ci.org/balihoo/play2-bootstrap3)
latest [![Build Status](https://travis-ci.org/balihoo/play2-bootstrap3.png)](https://travis-ci.org/balihoo/play2-bootstrap3)

play2-bootstrap3
================

View Helpers for Bootstrap 3 in Play 2


Using
===============
First you must add the play2-boostrap3 package to your build.sbt:
```
resolvers ++= Seq(
  "Sonatype Nexus Repository Manager Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Spray IO Release Repo" at "http://repo.spray.io"
)
libraryDependencies += "com.balihoo" %% "play2-bootstrap3" % (play.core.PlayVersion.current + "-SNAPSHOT")
```

In your views, you genreally want to update the implicitFieldConstructor. For exampel to use the basic form input control:
```
@import twirl.pimpForPlay._
@implicitFieldConstructor = @{ FieldConstructor( views.html.helper.bootstrap3.basicForm.inputFieldConstructor.f ) }
```

Altenratively to including the twirl.pimpForPlay._ import explicitly, you can add it to all your views by adding this to your build.sbt:
```
templatesImport += "twirl.pimpForPlay._"
```
