package com.eduardossampaio.mytasks.platformspecifics.sqldelight

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.eduardossampaio.mytasks.persistence.db.MyTasksDatabase

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MyTasksDatabase.Schema, context, "MyTaskDatabase")
    }
}