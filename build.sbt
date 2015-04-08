name := "fulfillment"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.4"

// Specify the local repos first for best performance.
resolvers ++= Seq(
  "Internal Snapshot Repository" at "https://archiva.office.balihoo.com/archiva/repository/snapshots",
  "Internal Repository" at "https://archiva.office.balihoo.com/archiva/repository/internal",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases",
  "Keyczar at Google Code" at "http://keyczar.googlecode.com/svn/trunk/java/maven/"
)

// Don't use the Maven Central repository.  Go through the local repo, so everything is cached.
externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)

libraryDependencies ++= Seq(
  "com.typesafe.play" % "play-json_2.10" % "2.4.0-M1",
  "net.logstash.logback" % "logstash-logback-encoder" % "4.2",
  "org.slf4s" %% "slf4s-api" % "1.7.10", // Scala-friendly wrapper for slf4j
  "org.slf4j" % "log4j-over-slf4j" % "1.7.10", // So 3rd party libraries that expect log4j can use slf4j
  "ch.qos.logback" % "logback-classic" % "1.1.2" // Log file handler for slf4j
)

scalacOptions in Test ++= Seq("-Yrangepos")


