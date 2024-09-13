package tomislav.ferit.rma_gymapp.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tomislav.ferit.rma_gymapp.data.UserDatabase
import tomislav.ferit.rma_gymapp.model.User
import tomislav.ferit.rma_gymapp.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = UserDatabase.getDatabase(application).userDao()
    private val repository = UserRepository(userDao)

    // Use MutableState<User?> as a regular variable
    var currentUser: MutableState<User?> = mutableStateOf(null)

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            currentUser.value = repository.loginUser(username, password)
        }
    }

    fun registerUser(user: User) {
        viewModelScope.launch {
            repository.registerUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }
}
