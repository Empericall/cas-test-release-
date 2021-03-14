name := """hanyuu"""
organization := "fork2"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies += javaJdbc
libraryDependencies += evolutions
libraryDependencies += guice
libraryDependencies += ws

libraryDependencies += "org.projectlombok" % "lombok" % "1.18.2" % "provided"
libraryDependencies += "io.swagger" %% "swagger-play2" % "1.6.0"

libraryDependencies += "com.h2database" % "h2" % "1.4.192"

libraryDependencies ++= Seq(
  "org.mybatis" % "mybatis" % "3.4.6",
  "org.mybatis" % "mybatis-guice" % "3.10",
  "org.mybatis.dynamic-sql" % "mybatis-dynamic-sql" % "1.1.0",
  "com.nimbusds" % "nimbus-jose-jwt" % "4.40",
  "com.google.inject.extensions" % "guice-multibindings" % "4.1.0"
)

libraryDependencies ++= Seq(
  "org.mapstruct" % "mapstruct" % "1.2.0.Final" % "provided",
  "org.mapstruct" % "mapstruct-processor" % "1.2.0.Final" % "provided",
  "org.mapstruct" % "mapstruct-jdk8" % "1.2.0.Final"
)