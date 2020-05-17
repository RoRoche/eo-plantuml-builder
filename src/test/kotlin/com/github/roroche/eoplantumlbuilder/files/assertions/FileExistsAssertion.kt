package com.github.roroche.eoplantumlbuilder.files.assertions

import com.github.roroche.eoplantumlbuilder.files.OutputFile
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

/**
 * Checks that a [OutputFile] exists and is a file.
 *
 * @property output The [OutputFile] to be checked.
 */
class FileExistsAssertion(
    private val output: OutputFile
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThat(
            output.file()
        ).exists().isFile
    }
}