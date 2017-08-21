import sbt.Keys._
import sbt._

name := "micro-srv-akka-http"

version := "0.0.1"

scalaVersion := "2.11.8"

val akkaVer = "2.5.4"
val akkaHttpVer = "10.0.9"
val jacksonVer = "2.9.0"
val scalatestVer = "3.0.4"

libraryDependencies ++= Seq(
  // akka
  "com.typesafe.akka" % "akka-stream_2.11" % akkaVer,
  "com.typesafe.akka" % "akka-slf4j_2.11" % akkaVer,
  "com.typesafe.akka" % "akka-testkit_2.11" % akkaVer,
  // akka-http
  "com.typesafe.akka" % "akka-http_2.11" % akkaHttpVer,
  "com.typesafe.akka" % "akka-http-testkit_2.11" % akkaHttpVer,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVer,
  "com.typesafe.akka" % "akka-http-jackson_2.11" % akkaHttpVer,
  // logback
  "ch.qos.logback" % "logback-classic" % "1.1.8",
  // json
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % jacksonVer,
  "com.fasterxml.jackson.core" % "jackson-core" % jacksonVer,
  "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVer,
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVer,
  "com.fasterxml.jackson.module" % "jackson-module-paranamer" % jacksonVer,
  // testing
  "org.scalatest" % "scalatest_2.11" % scalatestVer % Test
)

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

fork in run := true

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation", "-feature")
