package org.web25.appserver

/**
 * Simple class representing a two-dimensional size
 *
 * @param width the width of the size
 * @param height the height of the size
 * @author Felix Resch <felix.resch@web25.org>
 * @since 0.0.1
 */
class Size(width: Int, height: Int): Updateable<String>() {

    /**
     * the width of the size
     */
    var width: Int by monitored(width)

    /**
     * the height of the size
     */
    var height: Int by monitored(height)

    override val objectID: String = "size"

    override val isObject: Boolean = false
}