package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.assertions.DirectoryExistsAssertion
import com.github.roroche.eoplantumlbuilder.files.assertions.FileExistsAssertion
import com.github.roroche.eoplantumlbuilder.files.assertions.OutputFileThrowsExceptionAssertion
import com.github.roroche.eoplantumlbuilder.files.exceptions.DirectoryAlreadyExistsAsFileException
import com.github.roroche.eoplantumlbuilder.files.exceptions.DirectoryDoesNotExistException
import com.github.roroche.eoplantumlbuilder.files.fixtures.CreateDirectoryFixture
import com.github.roroche.eoplantumlbuilder.files.fixtures.CreateFileFixture
import com.github.roroche.eoplantumlbuilder.fixtures.FixturedAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/**
 * Tests for [ExistingDirectory].
 */
class ExistingDirectoryTests : TestsSuite(
    TestCase(
        "Directory does not exist and no fallback",
        OutputFileThrowsExceptionAssertion(
            outputFile = ExistingDirectory(
                file = tmpDirPath.resolve("doesnotexist").toFile()
            ),
            expectedClass = DirectoryDoesNotExistException::class.java
        )
    ),
    TestCase(
        "Directory does not exist and fallback creates it",
        FileExistsAssertion(
            output = ExistingDirectory(
                file = tmpDirPath.resolve("doesnotexist").toFile(),
                fallback = MkdirsFallback(
                    file = tmpDirPath.resolve("doesnotexist").toFile()
                )
            )
        )
    ),
    TestCase(
        "A directory exists",
        FixturedAssertion(
            fixtures = listOf(
                CreateDirectoryFixture(
                    directory = tmpDirPath.resolve("exists").toFile()
                )
            ),
            delegate = DirectoryExistsAssertion(
                output = ExistingFile(
                    file = tmpDirPath.resolve("exists").toFile()
                )
            )
        )
    ),
    TestCase(
        "An existing directory that is a file throws",
        FixturedAssertion(
            fixtures = listOf(
                CreateFileFixture(
                    file = tmpDirPath.resolve("exists").toFile()
                )
            ),
            delegate = OutputFileThrowsExceptionAssertion(
                outputFile = ExistingDirectory(
                    file = tmpDirPath.resolve("exists").toFile()
                ),
                expectedClass = DirectoryAlreadyExistsAsFileException::class.java
            )
        )
    )
) {
    /**
     * Companion object to statically declare a [TempDir].
     */
    companion object TmpDir {
        @TempDir
        lateinit var tmpDirPath: Path
    }
}