package com.eduardossampaio.mytasks.app.core.domain.utils

import com.eduardossampaio.mytasks.platformspecifics.generateUUID
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime



fun newId():String{
    return generateUUID();
}

fun newDateTime():LocalDateTime{
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}