package com.eduardossampaio.mytasks.coreApplication.domain.useCases.task

import com.eduardossampaio.mytasks.coreApplication.data.entities.Task
import com.eduardossampaio.mytasks.coreApplication.data.entities.hasToNotify
import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.coreApplication.domain.services.NotificationService

class UnarchiveTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService) {

    /**
     * Unarchive the task passed as parameter
     * @author Eduardo
     * @param task task to archive
     * @return if task was successfully archived
     */
    fun unarchiveTask(task: Task):Boolean{
        val taskToArchive = repository.getTask(task.id)
        if(taskToArchive != null) {
            taskToArchive.archived = false
            return repository.editTask(taskToArchive).also {
                if(task.hasToNotify()) {
                    notificationService.scheduleNotification(task)
                }
            }
        }else{
            return false
        }
    }
}