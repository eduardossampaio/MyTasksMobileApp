package com.eduardossampaio.mytasks.app.presentation.viewmodels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual open class BaseViewModel actual constructor() {
    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
}