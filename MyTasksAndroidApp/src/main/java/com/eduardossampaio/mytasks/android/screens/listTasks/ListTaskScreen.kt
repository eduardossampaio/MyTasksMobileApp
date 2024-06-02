package com.eduardossampaio.mytasks.android.screens.listTasks

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eduardossampaio.mytasks.android.R
import com.eduardossampaio.mytasks.android.mockTaskList
import com.eduardossampaio.mytasks.android.style.MyApplicationTheme
import com.eduardossampaio.mytasks.android.style.titleColor
import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.presentation.interactors.ListTasksInteractor
import com.eduardossampaio.mytasks.app.presentation.viewmodels.State
import com.eduardossampaio.mytasks.app.presentation.viewmodels.tasks.ListTasksViewModel


@Composable
fun ListTaskScreen(viewModel: ListTasksViewModel = ListTasksViewModel(ListTasksInteractor())) {
    val listState = viewModel.taskState.collectAsState()

    if (listState.value.state == State.SUCCESS) {
        val taskList = listState.value.value
        if (taskList != null) {
            ListTasks(taskList)
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListTasks(allTasks: List<Task>) {
    var taskList by remember {
        mutableStateOf(sortByCompletion(allTasks))
    }
//    val sortedTasks = sortByCompletion(tasksState.value)
//    var taskList = sortByCompletion(allTasks)
    val state = rememberLazyListState()
    LazyColumn( modifier = Modifier.padding(horizontal = 10.dp)) {
        itemsIndexed(taskList, key = {_, item -> item.id}) { index, task ->
            val tasks = taskList;
            val previous = if(index==0) tasks.first() else tasks[index-1]
            val showCompletedText = index == 0 && tasks.first().completed
            val showUncompletedText = previous.completed && !task.completed
            if (showCompletedText) {
               ListItemTitle(title = stringResource(id = R.string.completed))
            }else if(showUncompletedText){
                ListItemTitle(title = stringResource(id = R.string.uncompleted))
            }
            ListTaskItem(task,Modifier.animateItemPlacement()){
                taskList = sortByCompletion(taskList).toMutableStateList()
            }

        }


    }
}

@Composable
fun ListItemTitle(title:String){
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = Color.titleColor,
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
    )
}

@Composable
@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ListPreview() {
    MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ListTasks(mockTaskList)
        }
    }
}

private fun sortByCompletion(tasks:List<Task>): List<Task>{
    val completed = tasks.filter { it.completed }.sortedBy { it.createdDate }
    val uncompleted = tasks.filter { !it.completed }.sortedBy { it.createdDate }
    return mutableListOf<Task>().also {
        it.addAll(completed)
        it.addAll(uncompleted)
    }
}