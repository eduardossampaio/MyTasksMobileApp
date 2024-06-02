package com.eduardossampaio.mytasks.app.core.domain.useCases.taskList

import com.eduardossampaio.mytasks.app.core.data.entities.TaskList
import com.eduardossampaio.mytasks.app.core.data.entities.hasSubtasks
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskListRepository
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository

class DeleteTaskList(
    private val taskRepository: TaskRepository,
    private val taskListRepository: TaskListRepository
) {

    fun deleteTaskList(taskList: TaskList, deleteChildTasks: Boolean): Boolean {
        return taskListRepository.deleteTaskList(taskList).also { successfullyDeleted ->
            val deleteSubtasks = deleteChildTasks &&
                    taskList.hasSubtasks() &&
                    successfullyDeleted;

            if (deleteSubtasks) {
                taskList.tasks?.forEach {
                    taskRepository.deleteTask(it);
                }
            }
        }
    }

}