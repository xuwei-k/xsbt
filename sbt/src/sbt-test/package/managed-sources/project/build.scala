import sbt._,Keys._

object build extends Build{
	val fileName = "Foo.scala"
	val fileContents = List("object Foo")

	lazy val root = Project(
		"root",
		file(".")
	).settings(
		sourceGenerators in Compile <+= sourceManaged map { dir =>
			val f = dir / fileName
			IO.write(f,fileContents.mkString(IO.Newline))
			Seq(f)
		},
		TaskKey[Unit]("check") <<= (packageSrc in Compile) map { srcJar =>
			IO.withTemporaryDirectory{ dir =>
				if(! IO.unzip(srcJar,dir).exists{ file =>
					file.name == fileName && IO.readLines(file) == fileContents
				}){
					throw new Exception("test fail")
				}
			}
		}
	)
}
