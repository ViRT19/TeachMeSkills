package ru.rimus.jpcompose2

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route) {
         composable(route=Screen.HomeScreen.route){
             HomeView(navController = navController)
         }
         composable(route=Screen.SecondScreen.route){
             SecondView(navController = navController)
         }

    }
}