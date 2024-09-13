package tomislav.ferit.rma_gymapp.data

import androidx.room.*
import tomislav.ferit.rma_gymapp.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1")
    suspend fun loginUser(username: String, password: String): User?

    @Update
    suspend fun updateUser(user: User)
}
