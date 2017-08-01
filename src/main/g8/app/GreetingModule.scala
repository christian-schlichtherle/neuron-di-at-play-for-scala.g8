import controllers.GreeterController
import play.api.i18n.Langs
import play.api.mvc.ControllerComponents
import services.ServicesModule
import global.namespace.neuron.di.scala._

trait GreetingModule extends ServicesModule {

  lazy val greeterController: GreeterController = wire[GreeterController]

  def langs: Langs

  def controllerComponents: ControllerComponents
}
