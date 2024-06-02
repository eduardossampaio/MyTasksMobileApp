package com.eduardossampaio.mytasks.android.common

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.eduardossampaio.mytasks.android.R
import com.eduardossampaio.mytasks.android.style.darkBackgroundColor
import com.eduardossampaio.mytasks.android.style.white

@Composable
fun CircleCheckbox(selected: Boolean, enabled: Boolean = true, onChecked: () -> Unit) {
    
    val imageVector =
        if (selected) painterResource(id = R.drawable.baseline_check_circle_24)
        else painterResource(id = R.drawable.outline_circle)

    val tint =  if (selected) darkBackgroundColor else white
    val background = if (selected) white else Color.Transparent

    IconButton(onClick = { onChecked() },
        enabled = enabled) {

        Icon(painter = imageVector,
            tint = tint,
            modifier = Modifier.background(background, shape = CircleShape),
            contentDescription = "checkbox")
    }
}

@Composable
@Preview(name = "selected")
fun PreviewSelectedCheckbox(){
    CircleCheckbox(selected = true) {
        
    }
}

@Composable
@Preview(name = "unselected")
fun PreviewUnselectedCheckbox(){
    CircleCheckbox(selected = false) {

    }
}