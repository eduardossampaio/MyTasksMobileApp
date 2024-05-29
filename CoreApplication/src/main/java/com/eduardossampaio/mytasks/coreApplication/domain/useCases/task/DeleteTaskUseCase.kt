package com.eduardossampaio.mytasks.coreApplication.domain.useCases.task

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.Task
import com.eduardossampaio.mytasks.coreApplication.data.entities.hasToNotify
import com.eduardossampaio.mytasks.coreApplication.domain.services.NotificationService

class DeleteTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService) {

    fun deleteTask(task: Task): Boolean{
        return repository.deleteTask(task).also { successfullyDeleted ->
            if(task.hasToNotify() && successfullyDeleted){
                notificationService.cancelNotification(task)
            }
        }
    }
}