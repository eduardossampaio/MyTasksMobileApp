package com.eduardossampaio.mytasks.app.core.domain.useCases.task

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.app.core.domain.services.NotificationService

class ArchiveTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService
) {

    /**
     * Archives the task passed as parameter
     * @author Eduardo
     * @param task task to archive
     * @return if task was successfully archived
     */
    fun archiveTask(task: Task):Boolean{
        val taskToArchive = repository.getTask(task.id)
        if(taskToArchive != null) {
            taskToArchive.archived = true
            return repository.editTask(taskToArchive).also {
                notificationService.cancelNotification(task)
            }
        }else{
            return false
        }
    }
}