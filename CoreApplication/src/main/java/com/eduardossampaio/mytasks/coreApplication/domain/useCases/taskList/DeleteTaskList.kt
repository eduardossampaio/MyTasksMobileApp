package com.eduardossampaio.mytasks.coreApplication.domain.useCases.taskList

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskListRepository
import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.TaskList
import com.eduardossampaio.mytasks.coreApplication.data.entities.hasSubtasks
import com.eduardossampaio.mytasks.coreApplication.data.entities.isArchived

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