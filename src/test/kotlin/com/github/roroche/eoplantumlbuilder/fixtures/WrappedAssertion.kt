package com.github.roroche.eoplantumlbuilder.fixtures

import com.pragmaticobjects.oo.tests.Assertion

/**
 * Abstract class to wrap [Assertion].
 *
 * @property delegate The [Assertion] to wrap.
 */
abstract class WrappedAssertion(
    private val delegate: Assertion
) : Assertion by delegate