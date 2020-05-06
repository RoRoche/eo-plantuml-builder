package com.github.roroche.eoplantumlbuilder.classes

import ch.ifocusit.plantuml.utils.ClassUtils
import ch.ifocusit.plantuml.utils.PlantUmlUtils
import com.github.roroche.eoplantumlbuilder.assertions.ClsContainsExactlyAssertion
import com.github.roroche.eoplantumlbuilder.assertions.ClsThrowsAssertion
import com.github.roroche.eoplantumlbuilder.classes.exceptions.InvalidPackageException
import com.github.roroche.eoplantumlbuilder.examples.Car
import com.github.roroche.eoplantumlbuilder.examples.Driver
import com.github.roroche.eoplantumlbuilder.examples.Vehicle
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * [TestsSuite] to perform checks about [ClsInPackage].
 */
class ClsInPackageTest : TestsSuite(
    TestCase(
        "classes in package contains concrete classes",
        ClsContainsExactlyAssertion(
            classes = ClsInPackage(
                packageName = "com.github.roroche.eoplantumlbuilder.examples"
            ),
            expectedClasses = listOf(
                Car::class.java,
                Driver::class.java,
                Vehicle::class.java
            )
        )
    ),
    TestCase(
        "empty package returns throws",
        ClsThrowsAssertion(
            classes = ClsInPackage(
                packageName = "com.github.roroche.eoplantumlbuilder.examples.empty"
            ),
            expectedClass = InvalidPackageException::class.java,
            expectedMessage = "Invalid package 'com.github.roroche.eoplantumlbuilder.examples.empty', maybe missing or empty"
        )
    ),
    TestCase(
        "not existing package throws",
        ClsThrowsAssertion(
            classes = ClsInPackage(
                packageName = "com.github.roroche.eoplantumlbuilder.examples.missing"
            ),
            expectedClass = InvalidPackageException::class.java,
            expectedMessage = "Invalid package 'com.github.roroche.eoplantumlbuilder.examples.missing', maybe missing or empty"
        )
    )
)