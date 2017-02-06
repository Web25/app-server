package org.web25.appserver

/**
 * Class to store an update of a single property and the value
 *
 * @property value The new value of the property
 * @property keys The unique identifiers of the objects that should be updated
 * @author Felix Resch <felix.resch@web25.org>
 * @since 0.0.1
 */
data class Update(val value: Any, val keys: MutableList<String> = mutableListOf())