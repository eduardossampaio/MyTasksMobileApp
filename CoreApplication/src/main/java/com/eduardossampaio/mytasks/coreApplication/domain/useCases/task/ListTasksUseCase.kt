package com.eduardossampaio.mytasks.coreApplication.domain.useCases.task

import com.eduardossampaio.mytasks.coreApplication.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.coreApplication.data.entities.Task
import java.util.Date

class ListTasksUseCase(private val repository: TaskRepository) {
    /**
     * List all tasks
     * @param completed: if has to include the completed tasks
     * @param archived: if include archived tasks
     * @param initialDate: first date of range to search items
     * @param finalDate: last date of range to search items
     * @return the list of tasks matching parameter
     */
    fun listAllTasks(
        completed: Boolean = true,
        archived: Boolean = false,
        initialDate: Date? = null,
        finalDate: Date? = null
    ): List<Task> {
        val dateRange =
            if (initialDate != null && finalDate != null)
                Pair(initialDate, finalDate)
            else
                null
        return repository.listTasks(completed, archived, dateRange)
    }
}