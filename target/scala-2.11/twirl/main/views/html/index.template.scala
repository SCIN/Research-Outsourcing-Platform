
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>My AngularJS App</title>
  <link rel="shortcut icon" type="image/png" href=""""),_display_(/*6.53*/routes/*6.59*/.Assets.versioned("img/favicon.png")),format.raw/*6.95*/("""">
  <link rel="stylesheet" href=""""),_display_(/*7.33*/routes/*7.39*/.Assets.versioned("css/app.css")),format.raw/*7.71*/("""">
  <script data-main=""""),_display_(/*8.23*/routes/*8.29*/.Assets.versioned("js/main.js")),format.raw/*8.60*/("""" src=""""),_display_(/*8.68*/routes/*8.74*/.Assets.versioned("lib/requirejs/require.js")),format.raw/*8.119*/(""""></script>
</head>
<body>
  <ul class="menu">
    <li><a href="#/view1">view1</a></li>
    <li><a href="#/view2">view2</a></li>
  </ul>

  <div ng-view></div>

  <div>Angular seed app: v<span app-version></span></div>

</body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Tue Oct 25 14:24:45 PDT 2016
                  SOURCE: /Users/angelagao/Documents/SOC/ROP/app/views/index.scala.html
                  HASH: 96a3316f3e41b32cc32bdf8a3e57b87eaa68a471
                  MATRIX: 827->0|1004->151|1018->157|1074->193|1135->228|1149->234|1201->266|1252->291|1266->297|1317->328|1351->336|1365->342|1431->387
                  LINES: 32->1|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|39->8|39->8|39->8
                  -- GENERATED --
              */
          