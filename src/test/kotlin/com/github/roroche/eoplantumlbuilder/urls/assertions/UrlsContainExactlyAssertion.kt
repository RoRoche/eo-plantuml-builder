package com.github.roroche.eoplantumlbuilder.urls.assertions

import com.github.roroche.eoplantumlbuilder.urls.Urls
import com.pragmaticobjects.oo.tests.Assertion
import org.assertj.core.api.Assertions
import java.net.URL

/**
 * Assertion that checks that [Urls] contains given [List] of [URL].
 *
 * @property urls The [Urls] to check.
 * @property expectedUrls The expected [List] of [URL].
 */
class UrlsContainExactlyAssertion(
        private val urls: Urls,
        private val expectedUrls: List<URL>
) : Assertion {
    /**
     * Check the assertion.
     */
    override fun check() {
        Assertions.assertThat(
                urls.list()
        ).containsExactlyInAnyOrderElementsOf(
                expectedUrls
        )
    }
}