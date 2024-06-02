package com.eduardossampaio.mytasks.app.data.repository



import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.TaskChecklist
import com.eduardossampaio.mytasks.app.core.data.repository.task.TaskRepository
import com.eduardossampaio.mytasks.app.data.repository.sqlite.parse
import com.eduardossampaio.mytasks.app.data.repository.sqlite.parseString
import com.eduardossampaio.mytasks.app.data.repository.sqlite.toLong
import com.eduardossampaio.mytasks.persistence.db.MyTasksDatabase
import com.eduardossampaio.mytasks.persistence.db.TasksQueries
import kotlinx.datetime.LocalDateTime

class SqliteTaskRepository(private val database: MyTasksDatabase) : TaskRepository {
    private val tasksQueries: TasksQueries = database.tasksQueries;
    private val checkboxItemQueries = database.checkboxItemQueries

    override fun listTasks(
        includeCompleted: Boolean,
        includeArchived: Boolean,
        betweenDates: Pair<LocalDateTime, LocalDateTime>?
    ): List<Task> {
        return tasksQueries.selectAllTasks().executeAsList().map {
            it.parse(fetchCheckboxItems(it.id))

        }
    }

    override fun getTask(id: String): Task? {
        return tasksQueries
            .selectTaskById(id)
            .executeAsOneOrNull()
            ?.parse(fetchCheckboxItems(id))

    }

    override fun createNewTask(task: Task): Boolean {
        tasksQueries.transaction {
            tasksQueries.insertTasks(
                task.id,
                task.name,
                task.description,
                task.createdDate.parseString(),
                task.notificationDate?.parseString(),
            )
        }

        task.checkList?.forEach {
            checkboxItemQueries.insertCheckbox(it.id,it.name, task.id)
        }
        return true
    }

    override fun editTask(task: Task): Boolean {
        tasksQueries.transaction {
            tasksQueries.editTask(
                task.name,
                task.description,
                task.completed.toLong(),
                task.notificationDate?.parseString(),
                task.archived.toLong(),
                task.id
            )
            task.checkList?.forEach {
                checkboxItemQueries.updateCheckbox(it.name,it.checked.toLong(),it.id)
            }
        }
        return true
    }

    override fun deleteTask(task: Task): Boolean {
        tasksQueries.transaction {
            tasksQueries.deleteTask(task.id)
            task.checkList?.forEach {
                checkboxItemQueries.deleteCheckbox(it.id)
            }
        }
        return true
    }

    private fun fetchCheckboxItems(id:String): () -> List<TaskChecklist> =  {
        checkboxItemQueries
            .selectCheckboxes(id)
            .executeAsList().map { it.parse() }
    }
}