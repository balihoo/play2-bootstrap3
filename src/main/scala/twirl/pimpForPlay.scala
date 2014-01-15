package twirl

object pimpForPlay {
  implicit def implicitHtml(twirlHtml:twirl.api.HtmlFormat.Appendable) = new play.api.templates.Html(twirlHtml.buffer)


  implicit def implicitFieldConstructorFunction( f:views.html.helper.FieldElements => twirl.api.HtmlFormat.Appendable):views.html.helper.FieldElements => play.api.templates.Html = {
    (e:views.html.helper.FieldElements) => f(e)
  }
}
