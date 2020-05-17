package com.github.roroche.eoplantumlbuilder.files.exceptions

import java.io.File

/**
 * Exception representing that a file already exist as directory although it's expected to be a file.
 *
 * @param file The considered [File].
 */
class FileAlreadyExistsAsDirectoryException(
    file: File
): RuntimeException("File $file is expected to be a file, but already exist and is a directory")
