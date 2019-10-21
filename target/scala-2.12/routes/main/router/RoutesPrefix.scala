// @GENERATOR:play-routes-compiler
// @SOURCE:C:/dlp-test/conf/routes
// @DATE:Mon Oct 21 18:07:19 CEST 2019


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
