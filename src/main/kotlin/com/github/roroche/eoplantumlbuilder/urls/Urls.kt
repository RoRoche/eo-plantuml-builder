package com.github.roroche.eoplantumlbuilder.urls

import java.net.URL

/**
 * Interface representing Urls inside the project.
 */
interface Urls {
    /**
     * @return The list of URL.
     */
    fun list(): List<URL>

    /**
     * Convenient class to wrap Urls.
     *
     * @property origin The Urls to be decorated.
     */
    abstract class Wrap(
            private val origin: Urls
    ) : Urls by origin

    /**
     * Simple class with a [List] or [URL].
     *
     * @property urls The [List] or [URL].
     */
    class Simple(
            private val urls: List<URL>
    ) : Urls {
        override fun list(): List<URL> = urls
    }
}