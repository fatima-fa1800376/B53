package cmps312.lab3.lab10

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route : String,){

    object Home:Screen(route="home")
    object AddProject:Screen(route="addproject")
    object TodoHome:Screen(route="todohome")
    object AddTodo:Screen(route="addtodo")


}