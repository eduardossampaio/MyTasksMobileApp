package com.eduardossampaio.mytasks.app.core.data.repository.task

import kotlinx.datetime.LocalDateTime

/**
 * Base repository to retrieve data related
 * to Tasks
 */
interface TaskRepository {

    /**
     * Get a list of tasks matching the following arguments.
     * If no arguments are passed, it will returns all task,
     * (completed or not) that wasn't archived
     * @author Eduardo
     * @param includeCompleted: if true all tasks will be listened. If false,
     * only retrieved uncompleted tasks
     * @param includeArchived: if true, archivedTasks will be included,otherwise not
     * @param betweenDates: pair of dates, indicating to returns the tasks created between
     * the period passed
     */
    fun listTasks(
        includeCompleted:Boolean = true,
        includeArchived:Boolean = false,
        betweenDates:Pair<LocalDateTime,LocalDateTime>? = null): List<com.eduardossampaio.mytasks.app.core.data.entities.Task>

    /**
     * Retrieve single task
     * @author Eduardo
     * @param id: the task id
     * @return the task found or null
     */
    fun getTask(id:String): com.eduardossampaio.mytasks.app.core.data.entities.Task?

    /**
     * @author Eduardo
     * stores a new Task
     * @param task Task do create
     * @return true if task was successfully created
     */
    fun createNewTask(task: com.eduardossampaio.mytasks.app.core.data.entities.Task): Boolean

    /**
     * @author Eduardo
     * edit the Task passed as parameter
     * @param task Task do create
     * @return true if task was successfully edited
     */
    fun editTask(task: com.eduardossampaio.mytasks.app.core.data.entities.Task): Boolean

    /**
     * @author Eduardo
     * delete the Task passed as parameter
     * @param task Task do delete
     * @return true if task was successfully deleted
     */
    fun deleteTask(task: com.eduardossampaio.mytasks.app.core.data.entities.Task): Boolean
}