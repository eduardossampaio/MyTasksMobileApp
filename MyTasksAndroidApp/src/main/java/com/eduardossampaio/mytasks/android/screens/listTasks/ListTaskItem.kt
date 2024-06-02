package com.eduardossampaio.mytasks.android.screens.listTasks

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eduardossampaio.mytasks.android.common.CircleCheckbox
import com.eduardossampaio.mytasks.android.common.ItemCard
import com.eduardossampaio.mytasks.android.style.MyApplicationTheme
import com.eduardossampaio.mytasks.android.style.taskItemBackground
import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.core.data.entities.TaskChecklist
import com.eduardossampaio.mytasks.app.core.domain.utils.newDateTime
import com.eduardossampaio.mytasks.app.core.domain.utils.newId


@Composable
fun ListTaskItem(task: Task,modifier: Modifier = Modifier, onItemUpdated: () -> Unit){
//    val isChecked =
////        remember {
//        mutableStateOf(task.completed)
////    }
    var isChecked = task.completed
    val expanded = remember{ mutableStateOf(false) }
    val decoration =
        if(isChecked) TextDecoration.LineThrough
        else TextDecoration.None

    ItemCard(
        onClick = {expanded.value = !expanded.value },
        modifier = modifier
        .animateContentSize()
        .padding(top = 2.dp, bottom = 2.dp)
        .background(Color.taskItemBackground)
    ){
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            CircleCheckbox(
                selected = isChecked,
                onChecked = {
                    isChecked = !isChecked
                    task.completed = isChecked
                    onItemUpdated()
                })
        Column {
            Text(
                textDecoration = decoration,
                text = task.name
            )
            Text(
                text = task.description ?: "",
                textDecoration = decoration,
                maxLines = if(expanded.value) 999 else 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.alpha(0.5f)

            )
        }
        }

    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewListTaskItem(){
    val task = Task(
        newId(),
        "Tarefa 2",
        false,
        newDateTime(),
        null,
        "Lorem ipsum dolor sit amet. Et perferendis placeat ea labore temporibus in error eligendi id itaque nihil qui quae veniam. Ut illo nostrum aut enim repellat qui quaerat voluptate. Id eaque aspernatur et culpa nemo et consequatur repellendus in adipisci quibusdam.",
        checkList = listOf(
            TaskChecklist(newId(), "Item 3", true),
            TaskChecklist(newId(), "Item 4", false),
            TaskChecklist(newId(), "Item 5", false),
            TaskChecklist(newId(), "Item 6", false),
            TaskChecklist(newId(), "Item 7", false),
        )
    )
    MyApplicationTheme {
        ListTaskItem(task){

        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewListTaskItemshort(){
    val task = Task(
        newId(),
        "Tarefa 2",
        false,
        newDateTime(),
        null,
        "Lorem ipsum ",
        checkList = listOf(
            TaskChecklist(newId(), "Item 3", true),
            TaskChecklist(newId(), "Item 4", false),
            TaskChecklist(newId(), "Item 5", false),
            TaskChecklist(newId(), "Item 6", false),
            TaskChecklist(newId(), "Item 7", false),
        )
    )
    MyApplicationTheme {
        ListTaskItem(task){

        }
    }
}