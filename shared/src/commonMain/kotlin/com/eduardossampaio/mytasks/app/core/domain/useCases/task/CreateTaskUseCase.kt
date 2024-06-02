package com.eduardossampaio.mytasks.app.core.domain.useCases.task

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.TaskChecklist
import com.eduardossampaio.mytasks.app.core.data.entities.hasToNotify
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.app.core.domain.services.NotificationService
import com.eduardossampaio.mytasks.app.core.domain.utils.newDateTime
import com.eduardossampaio.mytasks.app.core.domain.utils.newId
import kotlinx.datetime.LocalDateTime


/**
 * UseCase to create a new Task
 * @author Eduardo
 * @property repository: repository to manage task storage
 */
class CreateTaskUseCase(
    private val repository: TaskRepository,
    private val notificationService: NotificationService
) {

    /**
     * Create a new task
     * @param name: the task names
     * @param description: the task descriptions
     * @param notificationDate: when this tasks should be notified to user
     * @param checkListItems: optional list of items to complete this task
     * @return true if task was successfully created
     */
    fun createNewTask(
        name: String,
        description: String?,
        notificationDate: LocalDateTime?,
        checkListItems: List<String> = emptyList()):Boolean {

        val task = Task(
            id = newId(),
            name = name,
            completed = false,
            createdDate = newDateTime(),
            notificationDate = notificationDate,
            description = description,
            archived = false,
            checkList = checkListItems.map { TaskChecklist(newId(), it, false) }
        )
        return repository.createNewTask(task).also { successfullySaved ->
            if(task.hasToNotify() && successfullySaved) {
                notificationService.scheduleNotification(task)
            }
        }
    }
}