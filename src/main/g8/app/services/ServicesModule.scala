package services

import global.namespace.neuron.di.scala._

trait ServicesModule {

  lazy val greetingService: GreetingService = wire[GreetingService]
}
