package com.eduardossampaio.mytasks.app.core.domain.services

import com.eduardossampaio.mytasks.app.core.data.entities.Task

/**
 * class responsible for manage the scheduling
 * of tasks
 * @author Eduardo
 */
interface NotificationService {

    /**
     * Schedule new notification for a task
     */
    fun scheduleNotification(task: Task)

    /**
     * cancel the scheduled notifications
     */
    fun cancelNotification(task: Task)



}