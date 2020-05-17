package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.assertions.DirectoryExistsAssertion
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
        "Directory does not exist and no fallback throws",
        OutputFileThrowsExceptionAssertion(
            outputFile = ExistingDirectory(
                file = tmpDirPath.resolve("does_not_exist").toFile()
            ),
            expectedClass = DirectoryDoesNotExistException::class.java
        )
    ),
    TestCase(
        "Directory does not exist and fallback creates it",
        DirectoryExistsAssertion(
            output = ExistingDirectory(
                file = tmpDirPath.resolve("does_not_exist_but_will_be_created").toFile(),
                fallback = MkdirsFallback(
                    file = tmpDirPath.resolve("does_not_exist_but_will_be_created").toFile()
                )
            )
        )
    ),
    TestCase(
        "A directory exists",
        FixturedAssertion(
            fixtures = listOf(
                CreateDirectoryFixture(
                    directory = tmpDirPath.resolve("existing_directory").toFile()
                )
            ),
            delegate = DirectoryExistsAssertion(
                output = ExistingDirectory(
                    file = tmpDirPath.resolve("existing_directory").toFile()
                )
            )
        )
    ),
    TestCase(
        "An existing directory that is a file throws",
        FixturedAssertion(
            fixtures = listOf(
                CreateFileFixture(
                    file = tmpDirPath.resolve("existing_file").toFile()
                )
            ),
            delegate = OutputFileThrowsExceptionAssertion(
                outputFile = ExistingDirectory(
                    file = tmpDirPath.resolve("existing_file").toFile()
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