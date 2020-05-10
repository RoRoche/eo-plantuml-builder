package com.github.roroche.eoplantumlbuilder.classes

import com.github.roroche.eoplantumlbuilder.classes.assertions.ClsContainsExactlyAssertion
import com.github.roroche.eoplantumlbuilder.classes.assertions.ClsIsEmptyAssertion
import com.github.roroche.eoplantumlbuilder.examples.Car
import com.github.roroche.eoplantumlbuilder.examples.Driver
import com.pragmaticobjects.oo.tests.TestCase
import com.pragmaticobjects.oo.tests.junit5.TestsSuite

/**
 * [TestsSuite] to perform checks about [ClsFiltered].
 */
class ClsFilteredTest : TestsSuite(
        TestCase(
                "classes in package filtered contains less classes",
                ClsContainsExactlyAssertion(
                        classes = ClsFiltered(
                                origin = ClsInPackage(
                                        packageName = "com.github.roroche.eoplantumlbuilder.examples"
                                ),
                                ignored = ClsWithNames(
                                        names = listOf(
                                                "com.github.roroche.eoplantumlbuilder.examples.Vehicle"
                                        )
                                )
                        ),
                        expectedClasses = listOf(
                                Car::class.java,
                                Driver::class.java
                        )
                )
        ),
        TestCase(
                "empty origin and filtered classes returns empty list",
                ClsIsEmptyAssertion(
                        classes = ClsFiltered(
                                origin = Classes.Simple(
                                        emptyList()
                                ),
                                ignored = Classes.Simple(
                                        listOf(ClsFilteredTest::class.java)
                                )
                        )
                )
        ),
        TestCase(
                "empty origin and empty filtered classes returns empty list",
                ClsIsEmptyAssertion(
                        classes = ClsFiltered(
                                origin = Classes.Simple(
                                        emptyList()
                                ),
                                ignored = Classes.Simple(
                                        emptyList()
                                )
                        )
                )
        ),
        TestCase(
                "origin and empty filtered classes returns concrete classes",
                ClsContainsExactlyAssertion(
                        classes = ClsFiltered(
                                origin = Classes.Simple(
                                        listOf(ClsFilteredTest::class.java)
                                ),
                                ignored = Classes.Simple(
                                        emptyList()
                                )
                        ),
                        expectedClasses = listOf(
                                ClsFilteredTest::class.java
                        )
                )
        )
)