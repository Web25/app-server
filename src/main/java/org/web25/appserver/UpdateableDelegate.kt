package org.web25.appserver

import kotlin.reflect.KProperty

/**
 * Created by felix on 2/5/17.
 */
class UpdateableDelegate<T: Any>(var value: T) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if(thisRef is Synchronizeable<Any>) {
            var curr: Synchronizeable<Any> = thisRef
            val update = Update(value = value)
            update.keys.add(property.name)
            while (true) {
                update.keys.add(curr.getObjectID().toString())
                if(curr.isObject || curr.parent == null)
                    break
                curr = curr.parent!!
            }
            thisRef.updateList.add(update)
        }
    }
}