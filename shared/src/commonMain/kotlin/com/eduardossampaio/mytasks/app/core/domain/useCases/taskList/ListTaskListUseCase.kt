package com.eduardossampaio.mytasks.app.core.domain.useCases.taskList

import com.eduardossampaio.mytasks.app.core.data.entities.TaskList
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskListRepository

class ListTaskListUseCase(private val repository: TaskListRepository) {

    fun getAllTaskList(includeArchived:Boolean = false):List<TaskList>{
        return repository.listAllTaskList(includeArchived)
    }
}