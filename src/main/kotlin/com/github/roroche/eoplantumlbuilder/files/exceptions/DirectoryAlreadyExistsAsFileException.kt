package com.github.roroche.eoplantumlbuilder.files.exceptions

import java.io.File

/**
 * Exception representing that a file already exist although it's expected to be a directory.
 *
 * @param file The considered [File].
 */
class DirectoryAlreadyExistsAsFileException(
    file: File
): RuntimeException("File $file is expected to be a directory, but already exist and is a file")
