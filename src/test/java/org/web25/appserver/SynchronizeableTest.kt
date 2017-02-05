package org.web25.appserver

import org.junit.jupiter.api.Test

/**
 * Created by felix on 2/5/17.
 */
class SynchronizeableTest {

    @Test
    internal fun testUpdateList() {
        val widget = Widget(120, 40)
        widget.size.height = 200
        println(widget.updateList)
    }
}