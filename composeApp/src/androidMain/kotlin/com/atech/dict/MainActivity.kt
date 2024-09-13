package com.atech.dict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.atech.dict.ui.theme.isSystemInDarkTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isSystemInDarkTheme(this)
        setContent {
            val systemUI = rememberSystemUiController()
            systemUI.setStatusBarColor(
                color = MaterialTheme.colorScheme.surface,
                darkIcons = true
            )
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}