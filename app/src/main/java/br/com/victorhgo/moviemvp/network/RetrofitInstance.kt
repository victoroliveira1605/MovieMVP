package br.com.victorhgo.moviemvp.network

import br.com.victorhgo.moviemvp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {
        private var retrofit: Retrofit? = null
        val client: Retrofit
            get() {
                val okhttp = okHttpClient.newBuilder()
                okhttp.readTimeout(60, TimeUnit.SECONDS)
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okhttp.addInterceptor(loggingInterceptor)

                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_URL)
                        .client(okhttp.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit!!
            }

        private val okHttpClient: OkHttpClient
            get() {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
                return OkHttpClient.Builder()
                    .connectTimeout(60L, TimeUnit.SECONDS)
                    .readTimeout(60L, TimeUnit.SECONDS)
                    .addInterceptor { chain ->
                        createParametersDefault(
                            chain
                        )
                    }
                    .addInterceptor(httpLoggingInterceptor).build()
            }

        private fun createParametersDefault(chain: Interceptor.Chain): Response {
            var request = chain.request()
            val builder = request.url().newBuilder()
            builder.addQueryParameter("api_key", BuildConfig.API_PRIVATE)
            request = request.newBuilder().url(builder.build()).build()
            return chain.proceed(request)
        }
    }
}