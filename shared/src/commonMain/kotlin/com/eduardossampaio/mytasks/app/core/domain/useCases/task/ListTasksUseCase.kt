package com.eduardossampaio.mytasks.app.core.domain.useCases.task


import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository
import kotlinx.datetime.LocalDateTime


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
        initialDate: LocalDateTime? = null,
        finalDate: LocalDateTime? = null
    ): List<Task> {
        val dateRange =
            if (initialDate != null && finalDate != null)
                Pair(initialDate, finalDate)
            else
                null
        return repository.listTasks(completed, archived, dateRange)
    }
}