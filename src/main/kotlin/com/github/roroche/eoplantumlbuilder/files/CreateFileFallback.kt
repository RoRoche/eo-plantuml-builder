package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.exceptions.UnableToCreateFileException
import java.io.File

/**
 * Create a [File] if it doesn't exist.
 *
 * @property file The [File] to be created.
 */
class CreateFileFallback(
    private val file: File
) : OutputFile.Fallback {
    /**
     * @return The create [File].
     */
    override fun file(): File {
        if (file.createNewFile()) {
            return file
        } else {
            throw UnableToCreateFileException(file)
        }
    }
}
