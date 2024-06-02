package com.eduardossampaio.mytasks.platformspecifics.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.eduardossampaio.mytasks.persistence.db.MyTasksDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MyTasksDatabase.Schema, "MyTaskDatabase")
    }
}