package com.github.roroche.eoplantumlbuilder.files.exceptions

import java.io.File

/**
 * Exception while creating directory using mkdirs.
 *
 * @param file The directory to create.
 */
class UnableToCreateDirectoryException(
    file: File
) : RuntimeException("Unable to create directory with mkdirs: $file")
