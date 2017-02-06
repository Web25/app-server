package org.web25.appserver

/**
 * Base class for all updateable objects
 *
 * @param T The type of the objectId
 * @author Felix Resch <felix.resch@web25.org>
 * @since 0.0.1
 */
abstract class Updateable<out T: Any> {

    /**
     * The parent of this updateable instance. This is neccessary to build the key chain properly
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    var parent: Updateable<Any>? = null
    private set

    /**
     * The list of all updates for this element. Should be flushed when they have been sent
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    //TODO it would probably be better to use a different delegate to actually use the parent everytime possible
    val updateList: MutableList<Update> by lazy {
        val parent = this.parent
        parent?.updateList ?: mutableListOf<Update>()
    }

    /**
     * Creates a delegate for the property that reports changes to the update list.
     *
     * If you add an updateable instance as a monitored property, the parent property is automatically set!
     *
     * @param T The type of the property
     * @param value The initial value of the property
     * @return A delegate that reports changes to the update list
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    fun <T: Any> monitored(value: T): UpdateableDelegate<T> {
        if(value is Updateable<Any>) {
            add(value)
        }
        return UpdateableDelegate(value)
    }

    /**
     * Adds an updateable instance to this updateable instance and sets the parent property
     *
     * If you add an updateable instance as a monitored property, the child is automatically added!
     *
     * @param updateable The child updateable
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    fun add(updateable: Updateable<Any>) {
        updateable.parent = this
    }

    /**
     * The ID of the object or the property.
     *
     * This value has to be:
     * <ul>
     *  <li>unique</li>
     * </ul>
     *
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    abstract val objectID: T

    /**
     * Whether the updateable instance is an object, hence has a global unique objectId
     *
     * @author Felix Resch <felix.resch@web25.org>
     * @since 0.0.1
     */
    abstract val isObject: Boolean
}

