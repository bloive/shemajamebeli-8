package com.example.shualeduri.network

import com.example.shualeduri.models.Result
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("/v3/48bb936e-261a-4471-a362-3bbb3b9a2a58")
    suspend fun getResult(): Response<Result>

}