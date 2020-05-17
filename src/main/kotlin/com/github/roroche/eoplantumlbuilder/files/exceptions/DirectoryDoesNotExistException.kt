package com.github.roroche.eoplantumlbuilder.files.exceptions

import java.io.File

/**
 * Exception to be thrown when a directory does not exist.
 *
 * @param file The directory that does not exist.
 */
class DirectoryDoesNotExistException(
    file: File
) : RuntimeException(
    "Directory $file does not exist"
)
