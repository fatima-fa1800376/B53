package com.cmps312.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.todoapp.view.AddProject
import com.cmps312.todoapp.view.Addtodo
import com.cmps312.todoapp.view.Home
import com.cmps312.todoapp.view.TodoHome

@Composable
fun AppNavHost(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.ProjectScreen.route) {

        composable(route = Screen.ProjectScreen.route) {
            Home(onAddProject = { navHostController.navigate(Screen.AddProject.route) },
                onProjectSelected = { navHostController.navigate(Screen.TodoHome.route) })
        }

        composable(route = Screen.AddProject.route) {
            AddProject(onAddProject = { navHostController.navigate(Screen.ProjectScreen.route) })
        }

        composable(route = Screen.TodoHome.route) {
            TodoHome(onNavigate = { navHostController.navigate(Screen.AddTodo.route) })
        }

        composable(route = Screen.AddTodo.route) {
            Addtodo(onAddTodo = { navHostController.navigate(Screen.TodoHome.route) })
        }
    }
}