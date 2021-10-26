package cmps312.lab3.lab10.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo
import cmps312.lab3.lab10.data.repository.TodoListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(appContext: Application) : AndroidViewModel(appContext) {

    private val todoListRepo by lazy { TodoListRepo(appContext) }
    var projects: LiveData<List<Project>> = todoListRepo.getProjects()

    lateinit var todos: LiveData<List<Todo>>
    lateinit var selectedTodo: Todo
    lateinit var selectedProject: Project

    fun getTodos(project: Project) {
        todos = todoListRepo.getTodoListByProject(project.id)
        Log.d("TAG", "getTodos: $project.id $project.name")
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.addTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.deleteTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.updateToDo(todo)
        }
    }

    fun addProject(project: Project) {
        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.addProject(project)
        }
    }

    fun deleteProject(project: Project) {
        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.deleteProject(project)
        }
    }


}