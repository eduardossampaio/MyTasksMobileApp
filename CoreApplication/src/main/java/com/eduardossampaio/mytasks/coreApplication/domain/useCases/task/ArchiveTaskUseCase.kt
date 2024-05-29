package com.eduardossampaio.mytasks.coreApplication.domain.useCases.task

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.Task
import com.eduardossampaio.mytasks.coreApplication.data.entities.hasToNotify
import com.eduardossampaio.mytasks.coreApplication.domain.services.NotificationService

class ArchiveTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService) {

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