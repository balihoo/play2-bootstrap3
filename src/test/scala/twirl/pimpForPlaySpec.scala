package twirl

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import views.html.helper.FieldElements

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class pimpForPlaySpec extends Specification {

  "pimpForPlay" should {

    "implicitly convert twirl html to play html" in {
      val twirlHtml = new twirl.api.HtmlFormat.Appendable("SomeText")


      def requiresPlayHtml(playHtml:play.api.templates.Html) = true

      import twirl.pimpForPlay._

      //Is there a better way to test this...it happens at compile time..so maybe not?
      requiresPlayHtml(twirlHtml) must beTrue

    }


    "implicitly convert twirl template f to play template f" in {

      import twirl.pimpForPlay._

      def requiresElementsToPlayHtmlLambda(f:FieldElements => play.api.templates.Html) = true

      //Note f is Elements to Twirl HTML, so this only works if the implicit is available
      requiresElementsToPlayHtmlLambda(views.html.helper.bootstrap3.basicForm.inputFieldConstructor.f) must beTrue

    }


  }
}
