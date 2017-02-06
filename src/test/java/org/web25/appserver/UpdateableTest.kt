package org.web25.appserver

import org.junit.jupiter.api.Test
import kotlin.test.*

/**
 * Created by felix on 2/5/17.
 */
class UpdateableTest {

    @Test
    internal fun testUpdateList() {
        val widget = Widget(120, 40)
        widget.size.height = 200
        val updates = widget.updateList
        assertEquals(1, updates.size)
        assertEquals(200, updates[0].value)
        assertEquals(listOf(widget.objectID.toString(), "size", "height"), updates[0].keys)
    }
}