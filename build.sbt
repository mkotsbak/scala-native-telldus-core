import sbtcrossproject.{CrossType, JS, JVM, Native}

enablePlugins(CrossProjectPlugin)

val scalaV = "2.11.8"
val projectName = "telldus-core"

nativeClangOptions := Seq(
  "-O2",
  "-g"
)

lazy val cross = crossProject.platform(JVM).platform(Native).crossType(CrossType.Full).in(file("."))

lazy val projectNative = cross.projects(Native).settings(
  name := projectName + "_sn",
  scalaVersion := scalaV,
  organization := "default"
).enablePlugins(ScalaNativePlugin)

lazy val projectJvm = cross.projects(JVM).settings(
  name := projectName,
  scalaVersion := scalaV,
  organization := "default",
  resolvers += Resolver.bintrayRepo("ullgren", "maven"),
  libraryDependencies += "net.juppi" % "jstick-api" % "1.4"
)
//lazy val projectJs = project.projects(JS)