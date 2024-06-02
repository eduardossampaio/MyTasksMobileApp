package com.eduardossampaio.mytasks.app.data.repository.sqlite

import com.eduardossampaio.mytasks.app.core.data.entities.TaskChecklist
import com.eduardossampaio.mytasks.persistence.db.CheckboxItem
import com.eduardossampaio.mytasks.persistence.db.TaskTable
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime


fun TaskTable.parse(checkboxItems: () -> List<TaskChecklist>): com.eduardossampaio.mytasks.app.core.data.entities.Task {
    return com.eduardossampaio.mytasks.app.core.data.entities.Task(
        id,
        name,
        completed.toBool(),
        creation_date.toLocalDateTime(),
        notification_date?.toLocalDateTime(),
        description,
        archived.toBool(),
        checkboxItems()
    )
}

fun CheckboxItem.parse():TaskChecklist = TaskChecklist(
    id = this.id.toString(),
    name = this.name,
    checked = this.completed.toBool()
)
fun Long.toBool(): Boolean = this == 1L;

fun Boolean.toDouble(): Double = if(this) 1.0 else 0.0;
fun Boolean.toLong(): Long = if(this) 1L else 0L;
fun Long.toDate(): LocalDateTime {
    return Instant
        .fromEpochMilliseconds(this)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}
fun LocalDateTime.toLong():Long{
    return this
        .toInstant(TimeZone.currentSystemDefault())
        .toEpochMilliseconds()

}

fun String.toDateTime():LocalDateTime{
    return LocalDateTime.parse(this);
}

fun LocalDateTime.parseString() : String{
    return this.toString()
}

