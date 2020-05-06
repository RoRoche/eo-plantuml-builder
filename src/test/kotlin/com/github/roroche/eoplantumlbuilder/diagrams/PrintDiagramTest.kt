package com.github.roroche.eoplantumlbuilder.diagrams

import com.github.roroche.eoplantumlbuilder.diagrams.assertions.FileHasContentAssertion
import com.github.roroche.eoplantumlbuilder.classes.ClsInPackage
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/**
 * [TestsSuite] to perform checks about printing [ClassDiagram].
 */
class PrintDiagramTest : TestsSuite(
    TestCase(
        "assert Diagram content is printed to file",
        FileHasContentAssertion(
            diagram = ClassDiagram(
                classes = ClsInPackage(
                    packageName = "com.github.roroche.eoplantumlbuilder.examples"
                )
            ),
            file = tmpDirPath.resolve("output.txt").toFile(),
            expectedContent = """
                @startuml

                class "Car" {
                  brand : String
                  model : String
                  driver : Driver
                }

                class "Driver" {
                  name : String
                  cars : List<Car>
                }

                interface "Vehicle"

                "Car" "*" <-> "Driver" : driver/cars
                "Vehicle" <|-- "Car"

                @enduml
            """.trimIndent()
        )
    )
) {
    /**
     * Companion object to statically declare a [TempDir].
     */
    companion object TmpDir {
        @TempDir
        lateinit var tmpDirPath: Path
    }
}