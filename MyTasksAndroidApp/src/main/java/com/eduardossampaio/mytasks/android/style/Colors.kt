package com.eduardossampaio.mytasks.android.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)

val primaryColorDark = Color(0xFFBB86FC)
val secondaryColorDark = Color(0xFF03DAC5)
val tertiaryDarkColor = Color(0xFF3700B3)

val primaryColorLight = Color(0xFF6200EE)
val secondaryColorLight = Color(0xFF03DAC5)
val tertiaryColorLight = Color(0xFF3700B3)

//Dark Mode
val darkBackgroundColor = Color(0xFF424360)
val darkOnBackgroundColor = Color(0xFF494A67)

val accentColorDark = Color(0xFF76DC58)
val primaryTextColorDark = Color(0xFFFFFFFF)
val secondaryTextColorDark = Color(0x80FFFFFF)

//Light Mode
val lightBackgroundColor = Color(0xFFCECFF8)


@OptIn(ExperimentalMaterial3Api::class)
val Color.Companion.TopBar
    @Composable
    get() = TopAppBarDefaults.topAppBarColors(
            containerColor = darkOnBackgroundColor)


val Color.Companion.NavigationColor: NavigationBarItemColors
    @Composable
    get() = NavigationBarItemDefaults.colors(
        selectedIconColor = accentColorDark,
        selectedTextColor = if(isSystemInDarkTheme()) white else black
    )


val Color.Companion.titleColor: Color
    get() = accentColorDark


val Color.Companion.taskItemBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) darkOnBackgroundColor.copy(alpha = 0.8f) else lightBackgroundColor

val Color.Companion.selectedIconColor: Color
    get() = accentColorDark

val Color.Companion.unselectedIconColor: Color
    get() = white


