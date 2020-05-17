package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.exceptions.DirectoryAlreadyExistsAsFileException
import com.github.roroche.eoplantumlbuilder.files.exceptions.DirectoryDoesNotExistException
import java.io.File

/**
 * Convenient class to create directory if it doesn't exist.
 *
 * @property file The [File] representing the directory.
 * @property fallback The optional [OutputFile.Fallback] to perform when the directory doesn't exist. Default is null.
 */
class ExistingDirectory(
    private val file: File,
    private val fallback: OutputFile.Fallback? = null
) : OutputFile {
    /**
     * @return The directory.
     */
    override fun file(): File {
        return if (file.exists()) {
            if (file.isDirectory) {
                file
            } else {
                throw DirectoryAlreadyExistsAsFileException(file)
            }
        } else fallback?.file() ?: throw DirectoryDoesNotExistException(file)
    }
}
