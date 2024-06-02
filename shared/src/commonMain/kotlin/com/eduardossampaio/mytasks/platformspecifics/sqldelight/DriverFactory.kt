package com.eduardossampaio.mytasks.platformspecifics.sqldelight

import app.cash.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver(): SqlDriver
}