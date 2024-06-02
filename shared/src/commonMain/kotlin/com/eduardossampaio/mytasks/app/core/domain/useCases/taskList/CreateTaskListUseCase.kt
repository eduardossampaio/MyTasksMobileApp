package com.eduardossampaio.mytasks.app.core.domain.useCases.taskList

import com.eduardossampaio.mytasks.app.core.data.entities.TaskList
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskListRepository
import com.eduardossampaio.mytasks.app.core.domain.utils.newId


class CreateTaskListUseCase(private val repository: TaskListRepository) {

    fun addNewTaskList(name: String){
        val taskList = TaskList(
            id = newId(),
            name = name,
            tasks = emptyList()
        )
        repository.createNewList(taskList)
    }
}