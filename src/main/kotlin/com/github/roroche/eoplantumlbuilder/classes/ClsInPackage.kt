package com.github.roroche.eoplantumlbuilder.classes

import com.github.roroche.eoplantumlbuilder.classes.exceptions.InvalidPackageException
import io.github.classgraph.ClassGraph

/**
 * Utility class to find [Classes] in a given package.
 *
 * @property packageName The name of the package to scan.
 */
class ClsInPackage(
    private val packageName: String
) : Classes {

    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        val classNames: MutableList<String> = ArrayList()
        ClassGraph().whitelistPackages(
            packageName
        ).enableClassInfo().scan().use { scanResult ->
            classNames.addAll(scanResult.allClasses.names)
        }
        if (classNames.isEmpty()) {
            throw InvalidPackageException(packageName)
        }
        return ClsWithNames(classNames).list()
    }
}