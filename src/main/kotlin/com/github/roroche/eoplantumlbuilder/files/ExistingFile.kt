package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.exceptions.FileAlreadyExistsAsDirectoryException
import com.github.roroche.eoplantumlbuilder.files.exceptions.FileDoesNotExistException
import java.io.File

/**
 * Convenient class to represent a file that exists (is created if not).
 * It also checks for its parent to be a directory that exists.
 *
 * @property file The [File] to check or create.
 * @property parent The [OutputFile] for representing its parent.
 * @property fallback The optional [OutputFile.Fallback] to perform if [File] does not exist. Default is null.
 */
class ExistingFile(
    private val file: File,
    private val parent: OutputFile,
    private val fallback: OutputFile.Fallback? = null
) : OutputFile {

    /**
     * Secondary constructor.
     *
     * @param file The [File] to check or create.
     * @param fallback The optional [OutputFile.Fallback] to perform if [File] does not exist. Default is null.
     */
    constructor(
        file: File,
        fallback: OutputFile.Fallback? = null
    ) : this(
        file = file,
        parent = ExistingDirectory(
            file = file.parentFile
        ),
        fallback = fallback
    )

    /**
     * @return The [File].
     */
    override fun file(): File {
        parent.file()
        return if (file.exists()) {
            if (file.isFile) {
                file
            } else {
                throw FileAlreadyExistsAsDirectoryException(file)
            }
        } else fallback?.file() ?: throw FileDoesNotExistException(file)
    }
}