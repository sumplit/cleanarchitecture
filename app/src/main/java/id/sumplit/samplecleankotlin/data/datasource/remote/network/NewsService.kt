package id.sumplit.samplecleankotlin.data.datasource.remote.network

import id.sumplit.samplecleankotlin.data.model.response.BaseApiResponse
import id.sumplit.samplecleankotlin.data.model.response.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getListNewsService(
        @Query("apiKey") apiKey: String?,
        @Query("country") country: String?,
        @Query("category") category: String?,
    ): BaseApiResponse<List<ListNewsResponse>>
}