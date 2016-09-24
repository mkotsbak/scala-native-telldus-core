## Overview

This is a facade/wrapper for Scala Native (http://www.scala-native.org/) for the Telldus Core library for the Tellstick hardware used to control lights etc. and reading sensors: http://telldus.se/

## Installation

* You need to have the Telldus library installed. It is available at e.g: http://telldus.se/produkt/tellstick-duo/
* Run `sbt publishLocal`
* Add dependency in your project:
```
libraryDependencies += "default" %% "scala-native-telldus-core" % "0.1-SNAPSHOT"
```
