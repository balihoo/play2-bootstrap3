package views.helper.bootstrap3.inlineForm

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import org.specs2.mock.Mockito

import views.html.helper._
import play.api.templates.Html
import java.util.UUID

import views.html.helper.bootstrap3.inlineForm.inputFieldConstructor

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class inputFieldConstructorSpec extends Specification with Mockito {

  "inlineForm inputFieldConstructor" should {


    "have has-error class and does not have p element when errors present" in {
      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns true
      val error1 = UUID.randomUUID().toString
      val error2 = UUID.randomUUID().toString
      mockFieldElements.errors returns Seq(error1, error2)
      mockFieldElements.infos returns Seq()
      mockFieldElements.args returns Map()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns "<input/>"


      val content = inputFieldConstructor(mockFieldElements).toString()
      content must contain("has-error")
      content must not contain("""<p class="help-block">""")


    }


    "not have has-error class or error p element when errors not present" in {
      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false
      val error1 = UUID.randomUUID().toString
      val error2 = UUID.randomUUID().toString
      //even though there are errors, becuase hasError returns false, these should not be output
      mockFieldElements.errors returns Seq(error1, error2)
      mockFieldElements.infos returns Seq()
      mockFieldElements.args returns Map()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns "<input/>"


      val content = inputFieldConstructor(mockFieldElements).toString()
      content must not contain("has-error")

      content must not contain(error1)
      content must not contain(error2)
    }

    "have label id and text with sr-only class" in {
      //sr only is for screen readers, inline form hides the label
      val id = UUID.randomUUID().toString
      val label = "label " + id

      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false
      mockFieldElements.id returns id
      mockFieldElements.label returns label
      mockFieldElements.args returns Map()

      val error1 = UUID.randomUUID().toString
      val error2 = UUID.randomUUID().toString
      mockFieldElements.errors returns Seq(error1, error2)
      mockFieldElements.infos returns Seq()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns "<input/>"


      val content = inputFieldConstructor(mockFieldElements).toString()
      content must contain(s"""<label for="$id" class="sr-only">$label</label>""")
    }

    "have no info messages displayed if present" in {

      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false

      val info1 = UUID.randomUUID().toString
      val info2 = UUID.randomUUID().toString
      mockFieldElements.errors returns Seq()
      mockFieldElements.infos returns Seq(info1, info2)
      mockFieldElements.args returns Map()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns "<input/>"


      val content = inputFieldConstructor(mockFieldElements).toString()
      content must not contain(s"""<p class="help-block">""")
    }


    "have existing class pre-pended" in {

      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false
      mockFieldElements.args returns Map()
      mockFieldElements.errors returns Seq()
      mockFieldElements.infos returns Seq()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns """<input class="someclass"/>"""

      //If the class attribute is already there with a class, prepend in the bootstrap3 one
      val content = inputFieldConstructor(mockFieldElements).toString()
      content must contain(s"""<input class="form-control someclass"/>""")
    }

    "have existing class inserted when class is blank" in {

      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false
      mockFieldElements.args returns Map()

      mockFieldElements.errors returns Seq()
      mockFieldElements.infos returns Seq()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns """<input class=""/>"""

      //If the class attribute is already there but empty, insert in the bootstrap3 one
      val content = inputFieldConstructor(mockFieldElements).toString()
      content must contain(s"""<input class="form-control "/>""")
    }


    "have class inserted when class is not present" in {

      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false
      mockFieldElements.args returns Map()

      mockFieldElements.errors returns Seq()
      mockFieldElements.infos returns Seq()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns """<input />""" //note the space is required..maybe this is a bug?

      //If the class attribute is not there insert in the bootstrap3 one

      val content = inputFieldConstructor(mockFieldElements).toString()
      content must contain(s"""<input class="form-control" />""")
    }

    "have class arg applied to outmost div" in {

      val mockFieldElements = mock[FieldElements]
      mockFieldElements.hasErrors returns false
      mockFieldElements.args returns Map('_class -> "someclass")

      mockFieldElements.errors returns Seq()
      mockFieldElements.infos returns Seq()

      val mockHtmlInput = mock[Html]
      mockFieldElements.input returns mockHtmlInput
      mockHtmlInput.toString returns """<input />""" //note the space is required..maybe this is a bug?

      //If the class attribute is not there insert in the bootstrap3 one

      val content = inputFieldConstructor(mockFieldElements).toString()
      content must contain(s"""<div class="form-group someclass""")
    }

  }
}
