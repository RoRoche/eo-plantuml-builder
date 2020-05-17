package com.github.roroche.eoplantumlbuilder.diagrams

import com.github.roroche.eoplantumlbuilder.files.OutputFile
import java.io.File

/**
 * Convenient class that prints [Diagram] into [File].
 *
 * @property diagram The [Diagram] to print.
 * @property output The [OutputFile] where to print.
 */
class PrintedDiagram(
    private val diagram: Diagram,
    private val output: OutputFile
) {

    /**
     * Secondary constructor.
     *
     * @param diagram The [Diagram] to print.
     * @param file The [File] where to print.
     */
    constructor(
        diagram: Diagram,
        file: File
    ) : this(
        diagram = diagram,
        output = OutputFile.Simple(file)
    )

    /**
     * @return The [File] after printing the [Diagram].
     */
    fun file(): File {
        diagram.print(output)
        return output.file()
    }
}