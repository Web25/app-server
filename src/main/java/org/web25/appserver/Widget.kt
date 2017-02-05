package org.web25.appserver

import java.util.*

/**
 * Created by felix on 2/5/17.
 */
class Widget(width: Int, height: Int): Synchronizeable<UUID>() {

    private val id by lazy { UUID.randomUUID() }

    var size : Size by monitored(Size(width, height))

    init {
        add(size)
    }

    override fun getObjectID(): UUID = id

    override val isObject: Boolean
        get() = true
}