package com.github.roroche.eoplantumlbuilder.urls

import com.github.roroche.eoplantumlbuilder.urls.assertions.UrlsContainExactlyAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/**
 * [TestsSuite] to perform checks about [FilesUrls].
 */
class FilesUrlsTest : TestsSuite(
        TestCase(
                "2 files return a single list with 2 URL",
                UrlsContainExactlyAssertion(
                        urls = FilesUrls(
                                files = listOf(
                                        tmpDirPath.resolve("file1.txt").toFile(),
                                        tmpDirPath.resolve("file2.txt").toFile()
                                )
                        ),
                        expectedUrls = listOf(
                                tmpDirPath.resolve("file1.txt").toUri().toURL(),
                                tmpDirPath.resolve("file2.txt").toUri().toURL()
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