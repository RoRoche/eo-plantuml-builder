package com.github.roroche.eoplantumlbuilder.files.assertions

import com.github.roroche.eoplantumlbuilder.files.OutputFile
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions.assertThat

/**
 * Checks that a [OutputFile] exists and is a directory.
 *
 * @property output The [OutputFile] to be checked.
 */
class DirectoryExistsAssertion(
        private val output: OutputFile
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        assertThat(
                output.file()
        ).exists()
        assertThat(
                output.file()
        ).isDirectory()
    }
}