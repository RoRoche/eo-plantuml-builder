package com.github.roroche.eoplantumlbuilder.urls

import java.io.File
import java.net.URL

/**
 * Utility class that builds URL from File.
 *
 * @property files The File to be transformed into URL.
 */
class FilesUrls(
        private val files: List<File>
) : Urls {

    /**
     * @return The list of URL.
     */
    override fun list(): List<URL> {
        return files.map { file ->
            file.toURI().toURL()
        }
    }
}