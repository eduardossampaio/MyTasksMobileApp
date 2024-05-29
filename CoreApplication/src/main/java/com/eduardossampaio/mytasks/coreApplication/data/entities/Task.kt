package com.eduardossampaio.mytasks.coreApplication.data.entities

import java.util.Date

/**
 * This class represents a single Task
 *
 * @author Eduardo
 *
 * @property id the task id,
 * @property name, representative name of the task
 * @property description optional detailed description of the task
 * @property createdDate indicates when this task was created
 * @property notificationDate optional date this task will be occur, can be used to notification
 * @property archived mark this task as archived, to don't show ii on the list but without deleting
 * @property checkList optional checklist, if you want to split the task in details
 */
data class Task(
    val id:String,
    var name:String,
    var completed: Boolean,
    var createdDate:Date,
    var notificationDate: Date?,
    var description:String?,
    var archived: Boolean = false,
    var checkList: List<TaskChecklist>?
)


fun Task.hasToNotify():Boolean{
    return notificationDate != null
}