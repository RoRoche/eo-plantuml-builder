package com.github.roroche.eoplantumlbuilder.files.assertions

import com.github.roroche.eoplantumlbuilder.files.OutputFile
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThatThrownBy

/**
 * Assertion that checks that [OutputFile] throws exception.
 *
 * @property outputFile The [OutputFile] to check.
 * @property expectedClass The [Exception] [Class] expected to be thrown.
 * @property expectedMessage The expected [Exception] message.
 */
class OutputFileThrowsExceptionAssertion(
    private val outputFile: OutputFile,
    private val expectedClass: Class<out Exception>,
    private val expectedMessage: String? = null
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        val thrown = assertThatThrownBy {
            outputFile.file()
        }
        thrown.isInstanceOf(
            expectedClass
        )
        expectedMessage.let {
            thrown.hasMessageContaining(
                expectedMessage
            )
        }
    }
}