package org.web25.appserver

import java.util.*

/**
 * Base Class for all Widgets that can be drawn on screen.
 *
 * @param width the width of the widget
 * @param height the height of the widget
 * @author Felix Resch <felix.resch@web25.org>
 * @since 0.0.1
 */
class Widget(width: Int, height: Int): Updateable<UUID>() {

    override val objectID: UUID by lazy { UUID.randomUUID() }

    /**
     * The size of the widget
     */
    var size : Size by monitored(Size(width, height))

    override val isObject: Boolean = true
}