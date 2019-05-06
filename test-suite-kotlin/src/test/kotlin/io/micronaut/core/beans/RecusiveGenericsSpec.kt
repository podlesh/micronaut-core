package io.micronaut.core.beans

import kotlin.test.Test
import kotlin.test.assertNotNull

class RecusiveGenericsSpec {
    // issue https://github.com/micronaut-projects/micronaut-core/issues/1607
    @Test
    fun testRecursiveGenericsOnBeanIntrospection() {
        val introspection = BeanIntrospection.getIntrospection(Item::class.java)
        // just check compilation works
        assertNotNull(introspection)
    }
}