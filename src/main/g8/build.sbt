lazy val root = (project in file(".")).enablePlugins(PlayScala, NeuronDIAtPlayForScalaPlugin)

name := "$name$"

scalaVersion := "$scala_version$"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "$scalatestplus_play_version$" % Test
