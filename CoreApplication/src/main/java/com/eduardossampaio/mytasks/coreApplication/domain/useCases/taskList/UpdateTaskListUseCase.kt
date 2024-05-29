package com.eduardossampaio.mytasks.coreApplication.domain.useCases.taskList

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskListRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.TaskList
import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository

class UpdateTaskListUseCase(
    private val taskListRepository: TaskListRepository,
    private val taskRepository: TaskRepository) {

    fun updateTaskList(taskList: TaskList){
        if (taskListRepository.editTaskList(taskList) ){
            taskList.tasks?.forEach {
                taskRepository.editTask(it)
            }
        }

    }
}