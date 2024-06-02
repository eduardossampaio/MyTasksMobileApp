package com.eduardossampaio.mytasks.app.core.data.entities

/**
 * This class represents a single Item on Task's checklist
 *
 * @author Eduardo
 * @property id id of this item
 * @property name name of the item
 * @property checked indicates if this item is completed or not
 */
data class TaskChecklist(
    val id:String,
    var name:String,
    var checked:Boolean
)
