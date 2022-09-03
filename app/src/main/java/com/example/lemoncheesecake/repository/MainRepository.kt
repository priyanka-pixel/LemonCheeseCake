package com.example.lemoncheesecake.repository

import com.example.lemoncheesecake.network.RetrofitService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(private val retrofitService: RetrofitService) {
     suspend fun getAllCakeAPI() = retrofitService.getLemonListService()

}