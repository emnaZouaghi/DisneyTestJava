
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object images extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(source: String, images: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.40*/("""

"""),_display_(/*3.2*/if(images!=null)/*3.18*/{_display_(Seq[Any](format.raw/*3.19*/("""
"""),format.raw/*4.1*/("""<h1>TASK 3</h1>
<ul>
"""),_display_(/*6.2*/for(image <- images) yield /*6.22*/ {_display_(Seq[Any](format.raw/*6.24*/("""
  """),format.raw/*7.3*/("""<img src="""),_display_(/*7.13*/image),format.raw/*7.18*/(""" """),format.raw/*7.19*/("""width="500" height="500">
""")))}),format.raw/*8.2*/("""
"""),format.raw/*9.1*/("""</ul> 
""")))}),format.raw/*10.2*/("""
"""),_display_(/*11.2*/if(source!=null)/*11.18*/{_display_(Seq[Any](format.raw/*11.19*/("""
 """),format.raw/*12.2*/("""<h1>TASK 2</h1>
  
  <img #imgID src="""),_display_(/*14.20*/source),format.raw/*14.26*/(""" """),format.raw/*14.27*/("""width="500" height="500">
""")))}))
      }
    }
  }

  def render(source:String,images:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(source,images)

  def f:((String,List[String]) => play.twirl.api.HtmlFormat.Appendable) = (source,images) => apply(source,images)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-10-09T20:21:30.595
                  SOURCE: C:/dlp-test/app/views/images.scala.html
                  HASH: 98dea127c759d12ff536dbdcb499ffe295e116e8
                  MATRIX: 962->1|1095->39|1125->44|1149->60|1187->61|1215->63|1264->87|1299->107|1338->109|1368->113|1404->123|1429->128|1457->129|1514->157|1542->159|1581->168|1610->171|1635->187|1674->188|1704->191|1771->231|1798->237|1827->238
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|38->6|38->6|38->6|39->7|39->7|39->7|39->7|40->8|41->9|42->10|43->11|43->11|43->11|44->12|46->14|46->14|46->14
                  -- GENERATED --
              */
          