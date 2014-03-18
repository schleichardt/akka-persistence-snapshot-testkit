organization := "info.schleichardt"

name := "akka-persistence-snapshot-testkit"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven"

val AkkaVersion = "2.3.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-persistence-experimental" % AkkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % AkkaVersion,
  "org.scalatest" %% "scalatest" % "2.0"
)

publishMavenStyle := true

publishArtifact in Test := false

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

val githubPath = "schleichardt/akka-persistence-snapshot-testkit"

pomExtra := (
  <url>https://github.com/{githubPath}</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:{githubPath}.git</url>
      <connection>scm:git:git@github.com:{githubPath}.git</connection>
    </scm>
    <developers>
      <developer>
        <id>schleichardt</id>
        <name>Michael Schleichardt</name>
        <url>http://michael.schleichardt.info</url>
      </developer>
    </developers>
  ) 
