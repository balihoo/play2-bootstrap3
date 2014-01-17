master [![Build Status](https://travis-ci.org/balihoo/play2-bootstrap3.png?branch=master)](https://travis-ci.org/balihoo/play2-bootstrap3)
latest [![Build Status](https://travis-ci.org/balihoo/play2-bootstrap3.png)](https://travis-ci.org/balihoo/play2-bootstrap3)

play2-bootstrap3
================

View Helpers & Field Construtors for Bootstrap 3 in Play 2.  Play generates bootstrap 2 compatible inputs, but if you want to use bootstrap 3 your are out of luck.  This package makes it easy to use bootstrap3 styling in your views and forms.


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
@import views.html.helper._
@import twirl.pimpForPlay._
@implicitFieldConstructor = @{ FieldConstructor( views.html.helper.bootstrap3.basicForm.inputFieldConstructor.f ) }
```

An altenative to including the twirl.pimpForPlay._ import explicitly, you can add the import to all your views by adding this to your build.sbt:
```
templatesImport += "twirl.pimpForPlay._"
```

Ditto the helper, although that's not there for play2-bootstrap3 just for FieldConstructor and inputText etc.

Credit
============
The original inspiration & code for this project was discussed at https://groups.google.com/forum/#!topic/play-framework/fVQbxZIC8vE
