package controllers

import global.namespace.neuron.di.scala._
import models.Greeting
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}
import play.twirl.api.Html
import services.GreetingService

@Neuron
trait GreeterController extends BaseController {

  def controllerComponents: ControllerComponents
  def greetingService: GreetingService
  def langs: Langs

  lazy val greetingsList: Seq[Greeting] = Seq(
    Greeting(1, greetingService.greetingMessage("en"), "sameer"),
    Greeting(2, greetingService.greetingMessage("it"), "sam")
  )

  def greetings = Action {
    Ok(Json.toJson(greetingsList))
  }

  def greetInMyLanguage = Action {
    Ok(greetingService.greetingMessage(langs.preferred(langs.availables).language))
  }

  def index = Action {
    Ok(Html("<h1>Welcome</h1><p>Your new application is ready.</p>"))
  }
}
