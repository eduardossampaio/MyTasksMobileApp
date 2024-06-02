package com.eduardossampaio.mytasks.android

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardossampaio.mytasks.android.screens.calendar.CalendarScreen
import com.eduardossampaio.mytasks.android.screens.listTasks.ListTaskScreen
import com.eduardossampaio.mytasks.android.screens.settings.SettingsScreen
import com.eduardossampaio.mytasks.android.style.MyApplicationTheme
import com.eduardossampaio.mytasks.android.style.NavigationColor
import com.eduardossampaio.mytasks.android.style.TaskCalendar
import com.eduardossampaio.mytasks.android.style.TaskIcon
import com.eduardossampaio.mytasks.android.style.TaskSettings
import com.eduardossampaio.mytasks.android.style.TopBar
import com.eduardossampaio.mytasks.android.style.selectedIconColor
import com.eduardossampaio.mytasks.android.style.titleColor
import com.eduardossampaio.mytasks.android.style.unselectedIconColor

enum class Screens(val route: String) {
    TASKS("Tasks"),
    CALENDAR("Calendar"),
    SETTINGS("Settings")
}

sealed class BottomNavItem(val screen: Screens, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem(
        Screens.TASKS,
        Icons.TaskIcon,
        MyApplication.instance.getString(R.string.tasks)
    )
    data object Search : BottomNavItem(
        Screens.CALENDAR,
        Icons.TaskCalendar,
        MyApplication.instance.getString(R.string.calendar))
    data object Profile : BottomNavItem(
        Screens.SETTINGS,
        Icons.TaskSettings,
        MyApplication.instance.getString(R.string.settings))

    companion object {
        fun allRoutes() = listOf(Home, Search, Profile)
    }
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}



@Composable
fun MainScreen(){
    val allTasksString = stringResource(id = R.string.all_tasks)
    val calendarString = stringResource(id = R.string.calendar)
    val settingsString = stringResource(id = R.string.settings)
    val title = remember {
        mutableStateOf(allTasksString)
    }
    val navController = rememberNavController()
    MyApplicationTheme {
        Surface(
            //color = Color.taskItemBackground,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Scaffold(
                topBar = {TopBar(title = title.value)},
                bottomBar = { BottomBar(navController)}
            ) { innerPadding ->
                Surface(
                    modifier =
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {

                    NavHost(navController = navController,
                        startDestination = Screens.TASKS.route,) {
                        composable(Screens.TASKS.route) {
                            title.value = allTasksString
                            ListTaskScreen()
                        }

                        composable(Screens.CALENDAR.route) {
                            title.value = calendarString
                            CalendarScreen()
                        }

                        composable(Screens.SETTINGS.route) {
                            title.value = settingsString
                            SettingsScreen()
                        }
                    }
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String){
    TopAppBar(
        title = { Text(text = title) },
        colors = Color.TopBar
    )
}
@Composable
fun BottomBar(navController: NavController) {
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }

        NavigationBar {
            BottomNavItem.allRoutes().forEachIndexed { index, navigationItem ->
                val selected = index == navigationSelectedItem
                NavigationBarItem(
                    selected = selected,
                    label = {
                        Text(navigationItem.label)
                    },
                    colors = Color.NavigationColor,
                    icon = {
                        Icon(
                            imageVector = navigationItem.icon,
                            contentDescription = navigationItem.label
                        )
                    },
                    onClick = {
                        navigationSelectedItem = index
                        navController.navigate(navigationItem.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

        }
}
@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewMainScreen(){
    MainScreen()
}
