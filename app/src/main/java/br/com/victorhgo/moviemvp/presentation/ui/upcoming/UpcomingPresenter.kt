package br.com.victorhgo.moviemvp.presentation.ui.upcoming

import android.content.Context
import android.util.Log
import br.com.victorhgo.moviemvp.model.UpcomingResponse
import br.com.victorhgo.moviemvp.network.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingPresenter(
    private val movieRepository: MovieRepository,
    private val mContext: Context
) : UpcomingContract.Presenter {
    override fun start() {
        movieRepository.getUpcomingRepository(1, "pt-BR")?.enqueue(object :
            Callback<UpcomingResponse> {
            override fun onResponse(
                call: Call<UpcomingResponse>,
                response: Response<UpcomingResponse>
            ) {
                Log.d("UPCOMING_RESPONSE", response.body().toString())
            }

            override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {
                Log.d("UPCOMING_RESPONSE", t.message!!)
            }
        })
    }
}