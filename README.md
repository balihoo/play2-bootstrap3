master [![Build Status](https://travis-ci.org/balihoo/play2-bootstrap3.png?branch=master)](https://travis-ci.org/balihoo/play2-bootstrap3)
latest [![Build Status](https://travis-ci.org/balihoo/play2-bootstrap3.png)](https://travis-ci.org/balihoo/play2-bootstrap3)

play2-bootstrap3
================

View Helpers and Field Construtors for Bootstrap 3 in Play 2. Play generates Bootstrap 2 compatible inputs, but if you want to use Bootstrap 3 you are out of luck. This package makes it easy to use Bootstrap 3 styling in your views and forms.


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

In your views, you generally want to update the implicitFieldConstructor. For example, to use the basic form input control:
```
@import views.html.helper._
@import twirl.pimpForPlay._
@implicitFieldConstructor = @{ FieldConstructor( views.html.helper.bootstrap3.basicForm.inputFieldConstructor.f ) }
```

As an altenative to including the twirl.pimpForPlay._ import explicitly, you can add the import to all your views by adding this to your build.sbt:
```
TwirlKeys.templateImports += "twirl.pimpForPlay._"
```

Ditto the helper, although that's not there for play2-bootstrap3, just for FieldConstructor and inputText etc.

If you're still a bit lost about what a field constructor is be sure to read about them in the [Play documentation](http://www.playframework.com/documentation/2.2.x/ScalaCustomFieldConstructors).

Credits
============
The original inspiration & code for this project was discussed [here](https://groups.google.com/forum/#!topic/play-framework/fVQbxZIC8vE).
