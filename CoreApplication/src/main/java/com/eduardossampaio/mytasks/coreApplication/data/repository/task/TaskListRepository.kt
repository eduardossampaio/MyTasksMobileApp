package com.eduardossampaio.mytasks.coreApplication.data.repository.task

import com.eduardossampaio.mytasks.coreApplication.data.entities.TaskList

interface TaskListRepository {

    fun listAllTaskList(includeArchived: Boolean = false):List<TaskList>

    fun createNewList(taskList: TaskList):Boolean

    fun editTaskList(taskList: TaskList):Boolean

    fun deleteTaskList(taskList: TaskList):Boolean
}