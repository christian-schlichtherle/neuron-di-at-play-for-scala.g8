import _root_.controllers.AssetsComponents
import global.namespace.neuron.di.scala._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.i18n._
import play.api.routing.Router
import router.Routes

class GreetingApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = new GreetingComponents(context).application
}

class GreetingComponents(context: Context) extends BuiltInComponentsFromContext(context)
  with GreetingModule
  with AssetsComponents
  with I18nComponents 
  with play.filters.HttpFiltersComponents {

  // Set up logger.
  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }

  lazy val router: Router = {
    // Put the prefix string in scope for the wire macro.
    val prefix = "/"
    wire[Routes]
  }
}
