enablePlugins(ScalaNativePlugin)

scalaVersion := "2.11.8"

nativeClangOptions := Seq(
  "-O2",
  "-g"
)