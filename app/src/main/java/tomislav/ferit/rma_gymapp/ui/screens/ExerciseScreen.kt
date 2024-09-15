package tomislav.ferit.rma_gymapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import tomislav.ferit.rma_gymapp.viewmodel.UserViewModel

@Composable
fun ExerciseScreen(userViewModel: UserViewModel, navController: NavController) {
    val exercises = listOf("Running", "Cycling", "Swimming", "Gym")
    var selectedExercise by remember { mutableStateOf(exercises[0]) }

    val currentUser = userViewModel.currentUser.value
    if (currentUser != null) {
        val weightLossRate = calculateWeightLossRate(selectedExercise, currentUser.calorieIntake)
        val daysToLoseWeight = calculateDaysToLoseWeight(currentUser.weight, weightLossRate)

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Select an exercise")
            DropdownMenu(
                expanded = true,
                onDismissRequest = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                exercises.forEach { exercise ->
                    DropdownMenuItem(onClick = { selectedExercise = exercise }) {
                        Text(text = exercise)
                    }
                }
            }

            Text(text = "You would need approximately $daysToLoseWeight days to reach your goal weight with $selectedExercise")

            Button(onClick = {
                Log.d("ExerciseScreen", "Back to Input button clicked")
                navController.navigate("inputScreen")
            }) {
                Text("Back to Input")
            }
        }
    } else {
        // Show some loading or error message
        Text("Loading user data...")
    }
}

fun calculateWeightLossRate(exercise: String, calorieIntake: Int): Float {
    return when (exercise) {
        "Running" -> 0.1f
        "Cycling" -> 0.08f
        "Swimming" -> 0.09f
        "Gym" -> 0.07f
        else -> 0.05f
    }
}

fun calculateDaysToLoseWeight(weight: Float, weightLossRate: Float): Int {
    return (weight / weightLossRate).toInt()
}
