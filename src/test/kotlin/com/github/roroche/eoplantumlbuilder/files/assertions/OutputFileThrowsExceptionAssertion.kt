package com.github.roroche.eoplantumlbuilder.files.assertions

import com.github.roroche.eoplantumlbuilder.files.OutputFile
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThatThrownBy

/**
 * Assertion that checks that [OutputFile] throws exception.
 *
 * @property outputFile The [OutputFile] to check.
 * @property expectedClass The [Exception] [Class] expected to be thrown.
 */
class OutputFileThrowsExceptionAssertion(
    private val outputFile: OutputFile,
    private val expectedClass: Class<out Exception>
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThatThrownBy {
            outputFile.file()
        }.isInstanceOf(
            expectedClass
        )
    }
}