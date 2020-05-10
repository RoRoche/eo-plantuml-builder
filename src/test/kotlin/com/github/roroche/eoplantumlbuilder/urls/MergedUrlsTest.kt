package com.github.roroche.eoplantumlbuilder.urls

import com.github.roroche.eoplantumlbuilder.urls.assertions.UrlsContainExactlyAssertion
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite
import java.net.URL

/**
 * [TestsSuite] to perform checks about [MergedUrls].
 */
class MergedUrlsTest : TestsSuite(
        TestCase(
                "multiple urls are merged in a single list",
                UrlsContainExactlyAssertion(
                        urls = MergedUrls(
                                urls = listOf(
                                        Urls.Simple(
                                                urls = listOf(
                                                        URL("https://www.google.com")
                                                )
                                        ),
                                        Urls.Simple(
                                                urls = listOf(
                                                        URL("https://github.com/")
                                                )
                                        )
                                )
                        ),
                        expectedUrls = listOf(
                                URL("https://www.google.com"),
                                URL("https://github.com/")
                        )
                )
        )
)