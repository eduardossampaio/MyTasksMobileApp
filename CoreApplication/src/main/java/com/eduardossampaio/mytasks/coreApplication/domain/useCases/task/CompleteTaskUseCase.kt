package com.eduardossampaio.mytasks.coreApplication.domain.useCases.task

import com.eduardossampaio.mytasks.coreApplication.data.entities.Task
import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.coreApplication.domain.services.NotificationService

class CompleteTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService) {

    fun completeTask(task: Task): Boolean{
        val taskToComplete = repository.getTask(task.id)
        if(taskToComplete != null) {
            taskToComplete.completed = true
            return repository.editTask(taskToComplete).also {
                notificationService.cancelNotification(task)
            }
        }else{
            return false
        }
    }
}