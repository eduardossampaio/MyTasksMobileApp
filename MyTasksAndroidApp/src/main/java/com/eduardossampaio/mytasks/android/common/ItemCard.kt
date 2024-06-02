package com.eduardossampaio.mytasks.android.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemCard(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null, content: @Composable () -> Unit){
    var localModifier = modifier
    if(onClick != null){
        localModifier = modifier.clickable { onClick() }
    }
    Column(modifier = localModifier
        .fillMaxWidth()
        .padding(10.dp)){
        content()
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewItemCard(){
    ItemCard{

        Text(text = "Teste");
        Text(text = "Teste");
    }
}