package tomislav.ferit.rma_gymapp.repository

import tomislav.ferit.rma_gymapp.data.UserDao
import tomislav.ferit.rma_gymapp.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) = userDao.registerUser(user)
    suspend fun loginUser(username: String, password: String) = userDao.loginUser(username, password)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
}
