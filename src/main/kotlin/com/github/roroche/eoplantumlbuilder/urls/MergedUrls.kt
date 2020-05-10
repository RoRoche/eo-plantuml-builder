package com.github.roroche.eoplantumlbuilder.urls

import java.net.URL

/**
 * Utility class to merge Urls.
 *
 * @property urls The list of Urls to be merged.
 */
class MergedUrls(
        private val urls: List<Urls>
) : Urls {
    /**
     * @return The list of merged URL.
     */
    override fun list(): List<URL> {
        return urls.flatMap {
            it.list()
        }
    }
}