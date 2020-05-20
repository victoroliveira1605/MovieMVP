package br.com.victorhgo.moviemvp.network

import br.com.victorhgo.moviemvp.model.UpcomingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/3/movie/upcoming")
    fun getUpcoming(
        @Query("page") page: Int,
        @Query("language") language: String

    ): Call<UpcomingResponse>
}