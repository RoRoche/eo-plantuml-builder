package com.github.roroche.eoplantumlbuilder.files

import com.github.roroche.eoplantumlbuilder.files.assertions.FileExistsAssertion
import com.github.roroche.eoplantumlbuilder.files.assertions.OutputFileThrowsExceptionAssertion
import com.github.roroche.eoplantumlbuilder.files.exceptions.DirectoryDoesNotExistException
import com.github.roroche.eoplantumlbuilder.files.exceptions.FileAlreadyExistsAsDirectoryException
import com.github.roroche.eoplantumlbuilder.files.exceptions.FileDoesNotExistException
import com.github.roroche.eoplantumlbuilder.files.fixtures.CreateDirectoryFixture
import com.github.roroche.eoplantumlbuilder.files.fixtures.CreateFileFixture
import com.github.roroche.eoplantumlbuilder.fixtures.FixturedAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/**
 * Test for [ExistingFile].
 */
class ExistingFileTests : TestsSuite(
    TestCase(
        "File does not exist and no fallback",
        OutputFileThrowsExceptionAssertion(
            outputFile = ExistingFile(
                file = tmpDirPath.resolve("does_not_exist_file.txt").toFile()
            ),
            expectedClass = FileDoesNotExistException::class.java
        )
    ),
    TestCase(
        "File does not exist and fallback creates it",
        FileExistsAssertion(
            output = ExistingFile(
                file = tmpDirPath.resolve("does_not_exist_file_but_will_be_created.txt").toFile(),
                fallback = CreateFileFallback(
                    file = tmpDirPath.resolve("does_not_exist_file_but_will_be_created.txt").toFile()
                )
            )
        )
    ),
    TestCase(
        "A file exists",
        FixturedAssertion(
            fixtures = listOf(
                CreateFileFixture(
                    file = tmpDirPath.resolve("existing_file.txt").toFile()
                )
            ),
            delegate = FileExistsAssertion(
                output = ExistingFile(
                    file = tmpDirPath.resolve("existing_file.txt").toFile()
                )
            )
        )
    ),
    TestCase(
        "An existing file that is a directory throws",
        FixturedAssertion(
            fixtures = listOf(
                CreateDirectoryFixture(
                    directory = tmpDirPath.resolve("existing_directory").toFile()
                )
            ),
            delegate = OutputFileThrowsExceptionAssertion(
                outputFile = ExistingFile(
                    file = tmpDirPath.resolve("existing_directory").toFile()
                ),
                expectedClass = FileAlreadyExistsAsDirectoryException::class.java
            )
        )
    ),
    TestCase(
        "A file with no parent and no fallback for it throws",
        OutputFileThrowsExceptionAssertion(
            outputFile = ExistingFile(
                file = tmpDirPath.resolve("parent_does_not_exist").resolve("does_not_exist.txt").toFile()
            ),
            expectedClass = DirectoryDoesNotExistException::class.java
        )
    ),
    TestCase(
        "A file exists after creating parent and itself",
        FileExistsAssertion(
            output = ExistingFile(
                file = tmpDirPath.resolve("parent_does_not_exist_but_will_be_created").resolve("does_not_exist_but_will_be_created.txt").toFile(),
                parent = ExistingDirectory(
                    file = tmpDirPath.resolve("parent_does_not_exist_but_will_be_created").toFile(),
                    fallback = MkdirsFallback(
                        file = tmpDirPath.resolve("parent_does_not_exist_but_will_be_created").toFile()
                    )
                ),
                fallback = CreateFileFallback(
                    file = tmpDirPath.resolve("parent_does_not_exist_but_will_be_created").resolve("does_not_exist_but_will_be_created.txt").toFile()
                )
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