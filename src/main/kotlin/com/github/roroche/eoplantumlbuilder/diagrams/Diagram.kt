package com.github.roroche.eoplantumlbuilder.diagrams

import com.github.roroche.eoplantumlbuilder.files.OutputFile
import java.io.File

/**
 * Class representing a PlantUML diagram.
 */
interface Diagram {

    /**
     * @return The content of the diagram.
     */
    fun content(): String

    /**
     * Print the content into the [File].
     *
     * @param output The [OutputFile] where to print content.
     */
    fun print(output: OutputFile)

    /**
     * Convenient class representing a simple diagram.
     *
     * @property content The content of the diagram.
     */
    class Simple(
        private val content: String
    ) : Diagram {
        /**
         * @return The content of the diagram.
         */
        override fun content() = content

        /**
         * Print the content into the [File].
         *
         * @param output The [OutputFile] where to print content.
         */
        override fun print(output: OutputFile) {
            output.file().writeText(content())
        }
    }

    /**
     * Convenient wrapper.
     *
     * @property delegate The delegate [Diagram].
     */
    abstract class Wrap(
        private val delegate: Diagram
    ) : Diagram by delegate
}