package com.eduardossampaio.mytasks.app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewModel : ViewModel(){
    actual val scope :CoroutineScope =  viewModelScope

}