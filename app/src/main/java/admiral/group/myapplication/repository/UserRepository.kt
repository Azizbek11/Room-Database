package admiral.group.myapplication.repository

import admiral.group.myapplication.data.UserDao
import admiral.group.myapplication.model.User
import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData:LiveData<List<User>> = userDao.readAllData()

    fun addUser(user: User){
        userDao.addUser(user)
    }
}