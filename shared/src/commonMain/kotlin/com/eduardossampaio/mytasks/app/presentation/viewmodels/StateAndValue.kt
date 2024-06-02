package com.eduardossampaio.mytasks.app.presentation.viewmodels

data class StateAndValue<T>(
    val state: State,
    val value:T? = null
){

    companion object{
        inline fun <T>loading(): StateAndValue<T> = StateAndValue(state = State.LOADING)

        inline fun <T> success(value:T) = StateAndValue(state = State.SUCCESS,value = value)
    }
}
