package com.github.roroche.eoplantumlbuilder.files

import java.io.File

/**
 * Interface representing the file to be printed into.
 */
interface OutputFile {
    /**
     * @return The file where to print.
     */
    fun file(): File

    /**
     * Convenient class to represent a simple [File].
     *
     * @property file The [File] to be printed.
     */
    class Simple(
        private val file: File
    ): OutputFile {
        /**
         * @return The file where to print.
         */
        override fun file() = file
    }

    /**
     * Convenient class to wrap an existing [OutputFile] and use as a delegate.
     *
     * @property delegate The delegated [OutputFile].
     */
    abstract class Wrap(
        private val delegate: OutputFile
    ): OutputFile by delegate

    /**
     * Interface representing how to recover an [OutputFile] when validators fail.
     */
    interface Fallback: OutputFile
}