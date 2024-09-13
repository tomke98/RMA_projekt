package tomislav.ferit.rma_gymapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import tomislav.ferit.rma_gymapp.model.User
import tomislav.ferit.rma_gymapp.viewmodel.UserViewModel

@Composable
fun LoginScreen(userViewModel: UserViewModel, navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoginMode by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())

        Button(onClick = {
            if (isLoginMode) {
                userViewModel.loginUser(username, password)
                if (userViewModel.currentUser != null) {
                    navController.navigate("inputScreen")
                }
            } else {
                val newUser = User(username = username, password = password, weight = 0f, height = 0f, calorieIntake = 0)
                userViewModel.registerUser(newUser)
                navController.navigate("inputScreen")
            }
        }) {
            Text(text = if (isLoginMode) "Login" else "Register")
        }

        TextButton(onClick = { isLoginMode = !isLoginMode }) {
            Text(text = if (isLoginMode) "Create Account" else "Back to Login")
        }
    }
}
