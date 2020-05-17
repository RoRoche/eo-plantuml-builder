package com.github.roroche.eoplantumlbuilder.files.fixtures

import com.github.roroche.eoplantumlbuilder.files.exceptions.UnableToCreateDirectoryException
import com.github.roroche.eoplantumlbuilder.fixtures.Fixture
import java.io.File

/**
 * Create a new directory.
 *
 * @property directory The directory to be created.
 */
class CreateDirectoryFixture(
    private val directory: File
) : Fixture {
    /**
     * Create the directory.
     */
    override fun perform() {
        if (!directory.mkdirs()) {
            throw UnableToCreateDirectoryException(directory)
        }
    }
}