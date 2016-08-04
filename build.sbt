/** Project */
name := "iterator-essence"

version := "1.5"

organization := "org.specs2"

scalaVersion := "2.11.8"

/** Shell */
shellPrompt := { state => System.getProperty("user.name") + "> " }

shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

/** Dependencies */
//resolvers ++= Seq("snapshots-repo" at "http://scala-tools.org/repo-snapshots", 
//                  "Local Maven Repository" at "file://$M2_REPO")

libraryDependencies ++= Seq(
  //"org.scala-tools.testing" % "scalacheck" % "1.12.5", 
  "org.scalacheck" % "scalacheck_2.11" % "1.13.2",
  "org.scala-tools.testing" % "test-interface" % "0.5", 
  //"org.specs2" %% "specs2-scalaz-core" % "7.2.4",
  "org.specs2" %% "specs2-core" % "3.7",
  "org.hamcrest" % "hamcrest-all" % "1.3",
  "org.mockito" % "mockito-all" % "1.10.19",
  "junit" % "junit" % "4.12",
  "org.pegdown" % "pegdown" % "1.6.0"
)

/** Compilation */
javacOptions ++= Seq("-Xmx1812m", "-Xms512m", "-Xss4m")

scalacOptions += "-deprecation"

maxErrors := 20

pollInterval := 1000

testFrameworks += new TestFramework("org.specs2.runner.SpecsFramework")

testOptions := Seq(Tests.Filter(s => s.matches("org.specs2.blog.*") || s.matches(".*Spec")))

/** Console */
initialCommands in console := "import org.specs2._"

// Packaging

/** Publishing */
//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

//publishTo <<= (version) { version: String =>
//  val nexus = "http://nexus-direct.scala-tools.org/content/repositories/"
//  if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus+"snapshots/") 
//  else                                   Some("releases" at nexus+"releases/")
//}
