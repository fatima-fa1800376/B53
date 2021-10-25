package cmps312.lab3.lab10.view

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.lab10.viewmodel.TodoViewModel

@Composable
fun AddProject(onAddProject:()->Unit){


    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val context = LocalContext.current

var projectName by remember { mutableStateOf("") }
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()


            ) {


            Text(text = "Add Project",
                Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp), fontWeight = FontWeight.Bold)

            OutlinedTextField(value = projectName,
                onValueChange = { projectName = it },
                label = { Text(text = "Project Name ") },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            Button(onClick = {
                if (
                    projectName.isNotEmpty()
                ) {
                    todoViewModel.selectedProject
                    todoViewModel.apply {
        selectedProject.let {
            todoViewModel.addProject(it)
        }
                    }


                    onAddProject()

                } else {
                    Toast.makeText(context, "Please provide all the information",
                        Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)) {
                Text(text = "Add Project")
            }
        }
    }


}