package cmps312.lab3.lab10

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        // floatingActionButton = { FAB(navHostController)}

    ) {
        AppNavHost(navHostController)
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = "Project List")
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)

    )
}