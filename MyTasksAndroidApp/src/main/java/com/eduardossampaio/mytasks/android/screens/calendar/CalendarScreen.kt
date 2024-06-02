package com.eduardossampaio.mytasks.android.screens.calendar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CalendarScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings")
    }
}