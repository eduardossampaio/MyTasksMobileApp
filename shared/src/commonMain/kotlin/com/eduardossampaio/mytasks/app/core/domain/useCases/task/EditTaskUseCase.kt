package com.eduardossampaio.mytasks.app.core.domain.useCases.task

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.hasToNotify
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.app.core.domain.services.NotificationService

class EditTaskUseCase (
    private val repository: TaskRepository,
    private val notificationService: NotificationService
) {

    fun editTask(task: Task): Boolean{
        return repository.editTask(task).also {
            if(task.hasToNotify()){
                notificationService.scheduleNotification(task)
            }else{
                notificationService.cancelNotification(task)
            }
        }
    }
}