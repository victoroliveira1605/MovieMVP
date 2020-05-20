package br.com.victorhgo.moviemvp.network

import br.com.victorhgo.moviemvp.model.UpcomingResponse
import retrofit2.Call

class MovieRepository {
    private var mMovieService: MovieService? = null

    init {
        mMovieService = RetrofitInstance.client.create(MovieService::class.java)
    }

    fun getUpcomingRepository(page: Int, language: String): Call<UpcomingResponse>? {
        return mMovieService?.getUpcoming(page, language)
    }
}