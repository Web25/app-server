package org.web25.appserver

/**
 * Created by felix on 2/5/17.
 */
class Size(width: Int, height: Int): Synchronizeable<String>() {

    var width: Int by monitored(width)
    var height: Int by monitored(height)

    override fun getObjectID(): String = "size"

    override val isObject: Boolean
        get() = false
}