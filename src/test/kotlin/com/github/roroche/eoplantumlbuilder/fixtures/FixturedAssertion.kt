package com.github.roroche.eoplantumlbuilder.fixtures

import com.pragmaticobjects.oo.tests.Assertion

/**
 * Convenient class to perform [Fixture] before [Assertion].
 *
 * @property fixtures The list of [Fixture] to perform.
 * @param delegate The [Assertion] to wrap.
 */
class FixturedAssertion(
    private val fixtures: List<Fixture>,
    delegate: Assertion
) : WrappedAssertion(delegate) {
    override fun check() {
        fixtures.forEach {
            it.perform()
        }
        super.check()
    }
}