name := "scala-lms-samples"

version := "1.0"

scalaVersion := "2.11.2"

scalaOrganization := "org.scala-lang.virtualized"

libraryDependencies += "org.scala-lang.lms" %% "lms-core" % "1.0.0-SNAPSHOT"

libraryDependencies += "org.scala-lang.virtualized" % "scala-compiler" % "2.11.2"

libraryDependencies += "org.scala-lang.virtualized" % "scala-library" % "2.11.2"

libraryDependencies += "org.scala-lang.virtualized" % "scala-reflect" % "2.11.2"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.2"

scalacOptions += "-Yvirtualize"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

resolvers += Resolver.sonatypeRepo("snapshots")

// support for unsigned primives in Scala
//libraryDependencies += "ch.ethz.acl" %% "scala-unsigned" % "0.1"
