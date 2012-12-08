import sbt._
import Keys._

object ApplicationBuild extends Build {

  lazy val main = Project(id = "main", base = file(".")).dependsOn(jsr310)

  lazy val jsr310 = uri("https://github.com/gakuzzzz/threeten.git")

}
