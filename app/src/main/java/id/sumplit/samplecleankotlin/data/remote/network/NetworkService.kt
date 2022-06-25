package id.sumplit.samplecleankotlin.data.remote.network

import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

class NetworkService {

    companion object {

        private fun okHttpBuilder(): OkHttpClient{
            val httpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)

//            val httpCacheDirectory = File(context.cacheDir, "responses")
//            try {
//                val cahce = Cache(httpCacheDirectory,  10 *1024* 1024)
//                httpClient.cache(cahce)
//            } catch (e: IOException){
//                e.printStackTrace()
//            }

            return httpClient.build()
        }

        fun createService(): NewsService{
            val mRetrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder())
                .build()

            return mRetrofit.create(NewsService::class.java)
        }
    }
}