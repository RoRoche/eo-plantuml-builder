package com.github.roroche.eoplantumlbuilder.classes

import com.github.roroche.eoplantumlbuilder.classes.exceptions.InvalidPackageException
import com.github.roroche.eoplantumlbuilder.urls.Urls
import io.github.classgraph.ClassGraph
import java.net.URL
import java.net.URLClassLoader

/**
 * Utility class to find [Classes] in a given package.
 *
 * @property packageName The name of the package to scan.
 * @property classGraph Utility to find classes in package.
 */
class ClsInPackage(
        private val packageName: String,
        private val classGraph: ClassGraph
) : Classes {

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     * @param classLoader The [ClassLoader] to use.
     */
    constructor(
            packageName: String,
            classLoader: ClassLoader
    ) : this(
            packageName = packageName,
            classGraph = ClassGraph(
            ).whitelistPackages(
                    packageName
            ).enableClassInfo(
            ).overrideClassLoaders(
                    classLoader
            )
    )

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     * @param urls The [URL] array to use.
     */
    constructor(
            packageName: String,
            urls: Array<URL>
    ) : this(
            packageName = packageName,
            classLoader = URLClassLoader(urls)
    )

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     * @param urls The [Urls] to use.
     */
    constructor(
            packageName: String,
            urls: Urls
    ) : this(
            packageName = packageName,
            urls = urls.list().toTypedArray()
    )

    /**
     * Secondary constructor.
     *
     * @param packageName The name of the package to scan.
     */
    constructor(
            packageName: String
    ) : this(
            packageName = packageName,
            classLoader = Thread.currentThread().contextClassLoader
    )

    /**
     * @return Classes to be used for diagram generation.
     */
    override fun list(): List<Class<out Any>> {
        classGraph.scan().use { scanResult ->
            return scanResult.allClasses.loadClasses().ifEmpty {
                throw InvalidPackageException(packageName)
            }
        }
    }
}