
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/angelagao/Documents/SOC/18655-Fall2016-Team4/conf/routes
// @DATE:Tue Oct 25 14:41:26 PDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
