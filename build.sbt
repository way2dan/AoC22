val AoC = project
  .in(file("."))
  .settings(
    name := "AoC",
    scalaVersion := "3.3.0",
    libraryDependencies += "co.fs2" %% "fs2-io" % "3.8.0",
  )
