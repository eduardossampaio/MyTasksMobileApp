package com.eduardossampaio.mytasks.coreApplication.data.entities

/**
 * This class represents a list of tasks
 * @author Eduardo
 * @property id id of the task list
 * @property name name of list
 * @property tasks list
 */
data class TaskList(
    val id:String,
    var name: String,
    var tasks: List<Task>?
)

/**
 * Task list is considered completed when all Tasks
 * is marked as completed
 */
fun TaskList.isCompleted(): Boolean {
    return checkIfAllTaskMatch { it.completed }
}

/**
 * Task list is considered archived when all Tasks
 * is marked as archived
 */
fun TaskList.isArchived():Boolean{
    return checkIfAllTaskMatch { it.archived }
}

private fun TaskList.checkIfAllTaskMatch(predicate: (Task)-> Boolean): Boolean{
    tasks.let { taskList->
        if(!taskList.isNullOrEmpty()){
            return taskList.count { predicate(it) } == taskList.size
        }
    }
    return false
}

fun TaskList.hasSubtasks():Boolean{
    return !tasks.isNullOrEmpty()
}