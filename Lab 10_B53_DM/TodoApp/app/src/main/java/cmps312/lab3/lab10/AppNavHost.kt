package cmps312.lab3.lab10

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cmps312.lab3.lab10.view.AddProject
import cmps312.lab3.lab10.view.Addtodo
import cmps312.lab3.lab10.view.Home
import cmps312.lab3.lab10.view.TodoHome

@Composable
fun AppNavHost(navHostController: NavHostController){

NavHost(navController = navHostController, startDestination = Screen.Home.route){

    composable(route=Screen.Home.route){
        Home(onNavigate = {navHostController.navigate(Screen.AddProject.route)})


    }

    composable(route=Screen.AddProject.route){
        AddProject(onAddProject = {navHostController.navigate(Screen.Home.route)})
    }

    composable(route = Screen.TodoHome.route){
        TodoHome(onNavigate = {navHostController.navigate(Screen.AddTodo.route)})
    }

    composable(route = Screen.AddTodo.route){
        Addtodo(onAddTodo = {navHostController.navigate(Screen.TodoHome.route)})
    }
}
}