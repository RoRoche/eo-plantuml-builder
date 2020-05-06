package com.github.roroche.eoplantumlbuilder.classes

import com.github.roroche.eoplantumlbuilder.classes.assertions.ClsContainsExactlyAssertion
import com.github.roroche.eoplantumlbuilder.classes.assertions.ClsIsEmptyAssertion
import com.github.roroche.eoplantumlbuilder.examples.Car
import com.github.roroche.eoplantumlbuilder.examples.Driver
import com.github.roroche.eoplantumlbuilder.examples.Vehicle
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * [TestsSuite] to perform checks about [ClsWithNames].
 */
class ClsWithNamesTest : TestsSuite(
    TestCase(
        "classes with names contains concrete classes",
        ClsContainsExactlyAssertion(
            classes = ClsWithNames(
                names = listOf(
                    "com.github.roroche.eoplantumlbuilder.examples.Car",
                    "com.github.roroche.eoplantumlbuilder.examples.Driver",
                    "com.github.roroche.eoplantumlbuilder.examples.Vehicle"
                )
            ),
            expectedClasses = listOf(
                Car::class.java,
                Driver::class.java,
                Vehicle::class.java
            )
        )
    ),
    TestCase(
        "classes with empty names returns empty list",
        ClsIsEmptyAssertion(
            classes = ClsWithNames(
                names = emptyList()
            )
        )
    ),
    TestCase(
        "classes with null names returns empty list",
        ClsIsEmptyAssertion(
            classes = ClsWithNames(
                names = null
            )
        )
    )
)