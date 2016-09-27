import sbtcrossproject.{CrossType, JS, JVM, Native}
import sbtcrossproject.CrossProjectPlugin.autoImport.crossProject // Import explicitly as it also exists in SJS plugin

enablePlugins(CrossProjectPlugin)

val scalaV = "2.11.8"
val projectName = "telldus-core"
val org = "io.github.mkotsbak"

lazy val cross = crossProject.platform(JVM).platform(Native).platform(JS).crossType(CrossType.Full).in(file("."))

lazy val projectJvm = cross.jvm.settings(
  name := projectName,
  scalaVersion := scalaV,
  organization := org,
  resolvers += Resolver.bintrayRepo("ullgren", "maven"),
  libraryDependencies += "net.juppi" % "jstick-api" % "1.4"
)

lazy val projectNative = cross.native.settings(
  name := projectName + "_sn",
  scalaVersion := scalaV,
  organization := org,
  nativeClangOptions := Seq(
    "-O2",
    "-g"
  )
).enablePlugins(ScalaNativePlugin)

lazy val projectJs = cross.js.settings(
  name := projectName,
  scalaVersion := scalaV,
  organization := org
).enablePlugins(ScalaJSPlugin)
