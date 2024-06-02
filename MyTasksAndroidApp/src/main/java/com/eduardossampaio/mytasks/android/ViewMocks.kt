package com.eduardossampaio.mytasks.android

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.TaskChecklist
import com.eduardossampaio.mytasks.app.core.domain.utils.newDateTime
import com.eduardossampaio.mytasks.app.core.domain.utils.newId

val mockTaskList = listOf(
    Task(
        newId(),
        "Tarefa 1",
        false,
        newDateTime(),
        null,
        "Fazer uns negocio ai",
        checkList = listOf(
            TaskChecklist(newId(), "Item 1", true),
            TaskChecklist(newId(), "Item 2", false)
        )
    ),
    Task(
        newId(),
        "Tarefa 2",
        false,
        newDateTime(),
        null,
        "Lorem ipsum dolor sit amet. Eos alias maiores aut mollitia fuga qui quis voluptate sit veritatis minus? In sint excepturi sit minima voluptatem et excepturi voluptates aut Quis corporis. Et eveniet quisquam est omnis blanditiis sed voluptas quidem est sunt minima est dolores culpa rem culpa quia",
        checkList = listOf(
            TaskChecklist(newId(), "Item 3", true),
            TaskChecklist(newId(), "Item 4", false),
            TaskChecklist(newId(), "Item 5", false),
            TaskChecklist(newId(), "Item 6", false),
            TaskChecklist(newId(), "Item 7", false),
        )
    ),
    Task(
        newId(),
        "Tarefa 3",
        false,
        newDateTime(),
        null,
        "Fazer uns outro negocio",
        checkList = listOf()
    ),
    Task(
        newId(),
        "Tarefa 4",
        false,
        newDateTime(),
        null,
        "Fazer uns negocio ai",
        checkList = listOf(
            TaskChecklist(newId(), "Item 3", true),
            TaskChecklist(newId(), "Item 4", false),
            TaskChecklist(newId(), "Item 5", false),
            TaskChecklist(newId(), "Item 6", false),
            TaskChecklist(newId(), "Item 7", false),
        ))
    )