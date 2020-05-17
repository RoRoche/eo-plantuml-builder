package com.github.roroche.eoplantumlbuilder.files.fixtures

import com.github.roroche.eoplantumlbuilder.files.exceptions.UnableToCreateFileException
import com.github.roroche.eoplantumlbuilder.fixtures.Fixture
import java.io.File

/**
 * Create a new [File].
 *
 * @property file The [File] to be created.
 */
class CreateFileFixture(
    private val file: File
) : Fixture {
    /**
     * Create the [File].
     */
    override fun perform() {
        if (!file.createNewFile()) {
            throw UnableToCreateFileException(file)
        }
    }
}