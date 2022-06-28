package id.sumplit.samplecleankotlin.data.datasource.remote.network

import id.sumplit.samplecleankotlin.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY

class NetworkService {

    companion object {

        private fun okHttpBuilder(): OkHttpClient{
            val logging = HttpLoggingInterceptor()
            logging.level = BODY

            val httpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
            return httpClient.build()
        }

        fun createService(): NewsService{
            val mRetrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder())
                .build()

            return mRetrofit.create(NewsService::class.java)
        }
    }
}