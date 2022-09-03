package com.example.lemoncheesecake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lemoncheesecake.adapter.CakeAdapter
import com.example.lemoncheesecake.databinding.ActivityMainBinding
import com.example.lemoncheesecake.databinding.LemonCakeBinding
import com.example.lemoncheesecake.network.RetrofitService
import com.example.lemoncheesecake.repository.MainRepository
import com.example.lemoncheesecake.viewmodel.MainViewModel
import com.example.lemoncheesecake.viewmodel.MyViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //private lateinit var viewModel: MainViewModel
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var activityBinding: ActivityMainBinding
    private val cakeAdapter = CakeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        activityBinding.recyclerView.adapter = cakeAdapter
        activityBinding.recyclerView.layoutManager = LinearLayoutManager(this)


        initializeService()
        callService()
        getDataToDisplay()
    }

    /**
     * retrofit
     * repository
     * constructor injection
     * dependency injection
     */
    fun initializeService(){

        //DI 1
        //val retrofitService = RetrofitService.getRetrofitInstance()
        //val repository = MainRepository(retrofitService)

        //DI2
        //viewModel = ViewModelProvider(this,MyViewModelFactory(repository)).get(MainViewModel::class.java)

    }
    fun callService(){
        viewModel.getCakeDataFromVM()
    }
    fun getDataToDisplay(){
        viewModel.respData.observe(this){
            Log.i("Cake",it.get(0).desc)
            cakeAdapter.submitList(it)
        }
    }
}