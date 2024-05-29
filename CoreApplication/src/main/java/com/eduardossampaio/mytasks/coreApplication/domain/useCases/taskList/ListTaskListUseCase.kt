package com.eduardossampaio.mytasks.coreApplication.domain.useCases.taskList

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskListRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.TaskList

class ListTaskListUseCase(private val repository: TaskListRepository) {

    fun getAllTaskList(includeArchived:Boolean = false):List<TaskList>{
        return repository.listAllTaskList(includeArchived)
    }
}