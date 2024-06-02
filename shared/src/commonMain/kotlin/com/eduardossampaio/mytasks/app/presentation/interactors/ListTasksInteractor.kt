package com.eduardossampaio.mytasks.app.presentation.interactors

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.TaskChecklist
import com.eduardossampaio.mytasks.app.core.domain.utils.newDateTime
import com.eduardossampaio.mytasks.app.core.domain.utils.newId

class ListTasksInteractor {

    fun listDefaultTasks():List<Task>{
        return listOf(
            Task(
                newId(),
                "Tarefa 1",
                false,
                newDateTime(),
                null,
                "Fazer uns negocio ai",
                checkList = listOf(
                    TaskChecklist(newId(), "Item 1", true),
                    TaskChecklist(newId(), "Item 2", false))
            ),
            Task(
                newId(),
                "Tarefa 2",
                false,
                newDateTime(),
                null,
                "Fazer uns negocio ai dois",
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
                true,
                newDateTime(),
                null,
                "Et explicabo praesentium et omnis voluptatum At exercitationem dolorem hic reiciendis sint. Vel dolorem magni et voluptatibus molestias aut unde recusandae sit veniam soluta ut dolores doloremque et mollitia velit a vitae possimus. Non molestias dolores vel dolore quibusdam a deserunt quia.",
                checkList = listOf()
            ),
            Task(
                newId(),
                "Tarefa 4",
                true,
                newDateTime(),
                null,
                "Fazer uns negocio ai",
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
                "Tarefa 5",
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
                )
            ), Task(
                newId(),
                "Tarefa 6",
                true,
                newDateTime(),
                null,
                "Lorem ipsum dolor sit amet. Sit odit officiis et quam excepturi in voluptatem dolore ut officia repellendus. Est laudantium voluptatem ut nobis veritatis eos delectus reiciendis et ducimus fuga? Aut labore soluta qui consequuntur dolorum qui voluptatem dolor.",
                checkList = listOf(
                )
            ),
        )
    }
}