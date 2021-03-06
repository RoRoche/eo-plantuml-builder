package com.github.roroche.eoplantumlbuilder.diagrams.assertions

import com.github.roroche.eoplantumlbuilder.diagrams.Diagram
import com.github.roroche.eoplantumlbuilder.diagrams.PrintedDiagram
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat
import java.io.File

/**
 * Kotlin specific assertion that checks that a file has a specific content.
 *
 * @property file The [File] to check.
 * @property expectedContent The expected content.
 */
class FileHasContentAssertion(
        private val file: File,
        private val expectedContent: String
) : Assertion {

    /**
     * Secondary constructor to build defaults params.
     *
     * @param diagram The [Diagram] to print in [File].
     * @param file The [File] where to print the [Diagram].
     * @param expectedContent The expected content.
     */
    constructor(
            diagram: Diagram,
            file: File,
            expectedContent: String
    ) : this(
            PrintedDiagram(
                    diagram,
                    file
            ).file(),
            expectedContent
    )

    /**
     * Check the assertion.
     */
    override fun check() {
        assertThat(
                file.readText()
        ).isEqualTo(
                expectedContent
        )
    }
}