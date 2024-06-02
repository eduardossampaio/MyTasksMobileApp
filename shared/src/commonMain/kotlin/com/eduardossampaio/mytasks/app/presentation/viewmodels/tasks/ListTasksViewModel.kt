package com.eduardossampaio.mytasks.app.presentation.viewmodels.tasks

import com.eduardossampaio.mytasks.app.core.data.entities.Task
import com.eduardossampaio.mytasks.app.presentation.interactors.ListTasksInteractor
import com.eduardossampaio.mytasks.app.presentation.viewmodels.BaseViewModel
import com.eduardossampaio.mytasks.app.presentation.viewmodels.StateAndValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListTasksViewModel(private val interactor: ListTasksInteractor) : BaseViewModel() {
    private val tasksStateMutableFlow = MutableStateFlow<StateAndValue<List<Task>>>(StateAndValue.loading())

    val taskState: StateFlow<StateAndValue<List<Task>>> = tasksStateMutableFlow

    init {
        listAllTasks()
    }

    fun listAllTasks(){
        scope.launch {
            val tasks = interactor.listDefaultTasks()
            tasksStateMutableFlow.emit(StateAndValue.success(tasks))
        }
    }


//
//    fun getArticles(forceRefresh: Boolean = false){
//        scope.launch {
//
//            _articleState.emit(ArticleState(loading = true, article = _articleState.value.article))
//
//            //delay(3000)
//
//            val fetched = useCase.getArticles(forceRefresh)
//
//            _articleState.emit(ArticleState(article = fetched, loading = false))
//
//        }
//    }

}