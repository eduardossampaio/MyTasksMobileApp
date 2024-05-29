package com.eduardossampaio.mytasks.coreApplication.domain.useCases.taskList

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskListRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.TaskList
import com.eduardossampaio.mytasks.coreApplication.domain.utils.newId

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