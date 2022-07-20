package admiral.group.myapplication.viewmodel

import admiral.group.myapplication.data.UserDatabase
import admiral.group.myapplication.repository.UserRepository
import admiral.group.myapplication.model.User
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    val readAllData:LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao= UserDatabase.getDatabase(application).userDao()
        repository= UserRepository(userDao)
        readAllData=repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}