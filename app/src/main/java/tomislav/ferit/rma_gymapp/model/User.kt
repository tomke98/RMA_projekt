package tomislav.ferit.rma_gymapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")  // Ensure table name is correct
data class User (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val password: String,
    val weight: Float,
    val height: Float,
    val calorieIntake: Int
)
