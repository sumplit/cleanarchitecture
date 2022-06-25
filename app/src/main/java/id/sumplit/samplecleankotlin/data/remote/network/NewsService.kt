package id.sumplit.samplecleankotlin.data.remote.network

import id.sumplit.samplecleankotlin.data.remote.response.BaseApiResponse
import id.sumplit.samplecleankotlin.data.remote.response.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything?q=tesla")
    suspend fun getListNewsService(
        @Query("apiKey") apiKey: String?,
        @Query("sortBy") publishedAt: String?,
        @Query("from") datePublishedAt: String?,
    ): BaseApiResponse<List<ListNewsResponse>>
}