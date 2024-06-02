package com.eduardossampaio.mytasks.app.core.domain.useCases.task

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.hasToNotify
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.app.core.domain.services.NotificationService

class DeleteTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService
) {

    fun deleteTask(task: Task): Boolean{
        return repository.deleteTask(task).also { successfullyDeleted ->
            if(task.hasToNotify() && successfullyDeleted){
                notificationService.cancelNotification(task)
            }
        }
    }
}