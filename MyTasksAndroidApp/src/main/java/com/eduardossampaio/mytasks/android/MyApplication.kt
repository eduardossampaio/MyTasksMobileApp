package com.eduardossampaio.mytasks.android

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object{
        lateinit var instance:Context;
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}