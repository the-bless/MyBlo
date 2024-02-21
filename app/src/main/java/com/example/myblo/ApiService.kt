package com.example.myblo

import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List < Post >
}
