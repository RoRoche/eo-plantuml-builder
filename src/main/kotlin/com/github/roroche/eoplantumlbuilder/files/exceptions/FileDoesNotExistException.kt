package com.github.roroche.eoplantumlbuilder.files.exceptions

import java.io.File

/**
 * Exception to be thrown when a [File] does not exist.
 *
 * @param file The [File] that does not exist.
 */
class FileDoesNotExistException(
    file: File
) : RuntimeException(
    "File $file does not exist"
)
