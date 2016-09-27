## Overview

This is a facade/wrapper for [Scala Native](http://www.scala-native.org/), [Scala.Js](https://www.scala-js.org/) and Scala on JVM for the Telldus Core library for the Tellstick hardware used to control lights etc. and reading sensors: http://telldus.se/

## Installation

* Until merged/published, you need to clone https://github.com/gurinderu/sbt-cross-project and do "sbt publishLocal" first
* You need to have the Telldus library installed. It is available at e.g: http://telldus.se/produkt/tellstick-duo/
* Run `sbt publishLocal`
* Add dependency in your client project:
```
libraryDependencies += "default" %% "scala-native-telldus-core" % "0.1-SNAPSHOT"
```

## Scala.Js version installation

* Run "npm install telldus"

## Example project

There is an [example project](https://github.com/mkotsbak/scala-native-tellstick-example) available
