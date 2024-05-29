package com.eduardossampaio.mytasks.coreApplication.data.repository.task

import com.eduardossampaio.mytasks.coreApplication.data.entities.Task
import java.util.Date

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
        betweenDates:Pair<Date,Date>? = null): List<Task>

    /**
     * Retrieve single task
     * @author Eduardo
     * @param id: the task id
     * @return the task found or null
     */
    fun getTask(id:String): Task?

    /**
     * @author Eduardo
     * stores a new Task
     * @param task Task do create
     * @return true if task was successfully created
     */
    fun createNewTask(task: Task): Boolean

    /**
     * @author Eduardo
     * edit the Task passed as parameter
     * @param task Task do create
     * @return true if task was successfully edited
     */
    fun editTask(task: Task): Boolean

    /**
     * @author Eduardo
     * delete the Task passed as parameter
     * @param task Task do delete
     * @return true if task was successfully deleted
     */
    fun deleteTask(task: Task): Boolean
}