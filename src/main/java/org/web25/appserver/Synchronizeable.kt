package org.web25.appserver

import java.util.*

/**
 * Created by felix on 2/5/17.
 */
abstract class Synchronizeable<out T: Any> {

    var parent: Synchronizeable<Any>? = null
    private set

    val updateList: MutableList<Update> by lazy {
        val parent = this.parent
        parent?.updateList ?: mutableListOf<Update>()
    }

    fun <T: Any> monitored(value: T): UpdateableDelegate<T> = UpdateableDelegate<T>(value)

    fun add(synchronizeable : Synchronizeable<Any>) {
        synchronizeable.parent = this
    }

    abstract fun getObjectID(): T
    abstract val isObject: Boolean
}

data class Update(val keys: MutableList<String> = mutableListOf(), val value: Any)
