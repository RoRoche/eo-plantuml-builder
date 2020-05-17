package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.exceptions.UnableToCreateDirectoryException
import java.io.File

/**
 * Convenient class to create directory when it doesn't exist.
 *
 * @property file The directory to create.
 */
class MkdirsFallback(
    private val file: File
) : OutputFile.Fallback {
    /**
     * @return The directory after creating it.
     */
    override fun file(): File {
        if (file.mkdirs()) {
            return file
        } else {
            throw UnableToCreateDirectoryException(file)
        }
    }
}