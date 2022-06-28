package id.sumplit.samplecleankotlin.data.datasource.remote

import id.sumplit.samplecleankotlin.BuildConfig
import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.data.datasource.remote.network.NetworkService
import id.sumplit.samplecleankotlin.data.model.response.ListNewsResponse

class RemoteDataSource() {

    private val service = NetworkService.createService()

    suspend fun getListNews(): ApiResponse<List<ListNewsResponse>>{
        return try {
                val response = service.getListNewsService(
                    apiKey = BuildConfig.API_KEY,
                    country = "us",
                    category = "business"
                )
                ApiResponse.Success(response.articles ?:arrayListOf())
            } catch (e: Exception){
                ApiResponse.Error(e.message.toString(), e)
            }
    }

    companion object {
        private val INSTANCE = RemoteDataSource()
        fun getInstance() = INSTANCE
    }
}