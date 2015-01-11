import sbt._, Keys._

trait Resolvers {
  val iliaz = "iliaz.com" at "http://scala.iliaz.com/"
  val sonatype = "sonatype" at "http://oss.sonatype.org/content/repositories/releases"
  val awesomepom = "awesomepom" at "https://raw.github.com/jibs/maven-repo-scala/master"
  val roundeights = "RoundEights" at "http://maven.spikemark.net/roundeights"
}

trait Dependencies {
  val scalaz = "org.scalaz" %% "scalaz-core" % "7.1.0"
  val specs2 = "org.specs2" %% "specs2" % "2.3.12" % "test"
  val scalalib = "com.github.ornicar" %% "scalalib" % "5.2"
  val jodaTime = "joda-time" % "joda-time" % "2.6"
  val jodaConvert = "org.joda" % "joda-convert" % "1.8"
}

object ApplicationBuild extends Build with Resolvers with Dependencies {

  private val buildSettings = Project.defaultSettings ++ Seq(
    scalaVersion := "2.11.5",
    organization := "org.lichess",
    version := "4.1",
    resolvers := Seq(iliaz, sonatype, awesomepom),
    libraryDependencies := Seq(scalaz, scalalib, jodaTime, specs2),
    updateOptions := updateOptions.value.withCachedResolution(true),
    scalacOptions := Seq(
      "-deprecation",
      "-unchecked",
      "-feature",
      "-language:_"))

  lazy val main = Project("scalachess", file("."), settings = buildSettings)
}
