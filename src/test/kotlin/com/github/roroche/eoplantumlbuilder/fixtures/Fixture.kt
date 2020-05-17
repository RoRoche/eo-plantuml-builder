package com.github.roroche.eoplantumlbuilder.fixtures

/**
 * A bunch of things to be performed before an [com.pragmaticobjects.oo.tests.Assertion].
 */
interface Fixture {
    /**
     * Perform what is expected.
     */
    fun perform()
}