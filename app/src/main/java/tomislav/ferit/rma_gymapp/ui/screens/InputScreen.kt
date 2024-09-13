package tomislav.ferit.rma_gymapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import tomislav.ferit.rma_gymapp.viewmodel.UserViewModel

@Composable
fun InputScreen(userViewModel: UserViewModel, navController: NavController) {
    var inputWeight by remember { mutableStateOf(0f) }
    var inputHeightValue by remember { mutableStateOf(0f) }
    var inputCalorieIntake by remember { mutableStateOf(0) }

    LaunchedEffect(userViewModel.currentUser) {
        userViewModel.currentUser.value?.let { user ->
            inputWeight = user.weight
            inputHeightValue = user.height
            inputCalorieIntake = user.calorieIntake
        }
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = inputWeight.toString(), onValueChange = { inputWeight = it.toFloat() }, label = { Text("Weight") })
        TextField(value = inputHeightValue.toString(), onValueChange = { inputHeightValue = it.toFloat() }, label = { Text("Height") })
        TextField(value = inputCalorieIntake.toString(), onValueChange = { inputCalorieIntake = it.toInt() }, label = { Text("Calories") })

        Button(onClick = {
            userViewModel.currentUser?.value?.let { user ->
                userViewModel.updateUser(user.copy(weight = inputWeight, height = inputHeightValue, calorieIntake = inputCalorieIntake))
                navController.navigate("exerciseScreen")
            }
        }) {
            Text("Next")
        }
    }
}
