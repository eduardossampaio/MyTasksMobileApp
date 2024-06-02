package com.eduardossampaio.mytasks.platformspecifics

import java.util.UUID

actual fun generateUUID(): String = UUID.randomUUID().toString()