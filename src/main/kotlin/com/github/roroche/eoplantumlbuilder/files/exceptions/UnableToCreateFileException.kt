package com.github.roroche.eoplantumlbuilder.files.exceptions

import java.io.File

/**
 * Exception while creating file.
 *
 * @param file The file to create.
 */
class UnableToCreateFileException(
    file: File
) : RuntimeException("Unable to create file: $file")
