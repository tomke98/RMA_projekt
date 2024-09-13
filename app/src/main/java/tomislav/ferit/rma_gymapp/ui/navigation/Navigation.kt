package tomislav.ferit.rma_gymapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tomislav.ferit.rma_gymapp.ui.screens.ExerciseScreen
import tomislav.ferit.rma_gymapp.ui.screens.InputScreen
import tomislav.ferit.rma_gymapp.ui.screens.LoginScreen
import tomislav.ferit.rma_gymapp.viewmodel.UserViewModel

@Composable
fun GymAppNavHost(userViewModel: UserViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") { LoginScreen(userViewModel, navController) }
        composable("inputScreen") { InputScreen(userViewModel, navController) }
        composable("exerciseScreen") { ExerciseScreen(userViewModel, navController) }
    }
}
