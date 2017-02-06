package org.web25.appserver

import kotlin.reflect.KProperty

/**
 * Delegate to store changes in a property in an update list to send them to another device.
 *
 * @author Felix Resch <felix.resch@web25.org>
 * @since 0.0.1
 * @property value The initial value of the property
 * @param T The type of the property
 */
class UpdateableDelegate<T: Any>(var value: T) {

    /**
     * Simply returns the value of the property, no logging is required for reading
     *
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = this.value

    /**
     * If the monitored instance is an updateable object, the changes will be stored in the
     * update list.
     *
     * The update will store all keys up to the first object of the property that has been changed.
     *
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if(thisRef is Updateable<Any>) {
            var curr: Updateable<Any> = thisRef
            val update = Update(value)
            update.keys.add(property.name)      //Add the name of the property first, so we also have it in the key list
            while (true) {
                update.keys.add(curr.objectID.toString())
                val parent = curr.parent
                if(curr.isObject || parent == null)         //If we reached the first object we don't need to add it to
                // the key list anymore, also if there is no parent we can't add it to the list
                    break
                curr = parent
            }
            update.keys.reverse()
            thisRef.updateList.add(update)
        }
        this.value = value      // store the new value
    }
}