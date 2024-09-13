package tomislav.ferit.rma_gymapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import tomislav.ferit.rma_gymapp.ui.navigation.GymAppNavHost
import tomislav.ferit.rma_gymapp.ui.theme.RMA_gymAppTheme
import tomislav.ferit.rma_gymapp.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewModel
        val userViewModel: UserViewModel by viewModels()

        // Set up the Compose UI
        setContent {
            val navController = rememberNavController()
            RMA_gymAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    GymAppNavHost(userViewModel, navController)
                }
            }
        }
    }
}
