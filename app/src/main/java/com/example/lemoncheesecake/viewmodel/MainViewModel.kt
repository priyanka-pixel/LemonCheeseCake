package com.example.lemoncheesecake.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lemoncheesecake.model.LemonIDcakeItem
import com.example.lemoncheesecake.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

//viewModel
//Livedata
//coroutine cell
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(){
       val errorMsg = MutableLiveData<String>()
       val respData = MutableLiveData<List<LemonIDcakeItem>>()
       var job: Job? = null

       fun getCakeDataFromVM(){
           job = CoroutineScope(Dispatchers.IO).launch {
               val response = repository.getAllCakeAPI()
               withContext(Dispatchers.Main){
                   respData.postValue(response.body())
               }
           }

       }


}