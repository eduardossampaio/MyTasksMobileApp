package com.eduardossampaio.mytasks.app.presentation.viewmodels

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}