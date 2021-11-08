package cmps312.lab3.lab11

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cmps312.lab3.lab11.view.AddProject
import cmps312.lab3.lab11.view.Addtodo
import cmps312.lab3.lab11.view.Home
import cmps312.lab3.lab11.view.TodoHome

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