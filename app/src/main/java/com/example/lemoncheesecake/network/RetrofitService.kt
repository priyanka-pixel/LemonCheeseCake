package com.example.lemoncheesecake.network



import com.example.lemoncheesecake.model.LemonIDcakeItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    //perform network
    //list and data class
    @GET(APIendpoint.API_CAKE_LIST)
    suspend fun getLemonListService(): Response<List<LemonIDcakeItem>>

//  companion object {
  //    var retrofitService: RetrofitService? = null

      //  fun getRetrofitInstance(): RetrofitService {
        //    if (retrofitService == null) {
          //      val retrofit = Retrofit.Builder()
            //        .baseUrl((APIendpoint.BASE_URL))
              //      .addConverterFactory(GsonConverterFactory.create()) //convert to java object
                //    .build()
                //retrofitService = retrofit.create(RetrofitService::class.java)

           // }
            //return retrofitService!!
        //}

    //}
}
