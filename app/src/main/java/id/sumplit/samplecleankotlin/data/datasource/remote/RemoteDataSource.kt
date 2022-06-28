package id.sumplit.samplecleankotlin.data.datasource.remote

import id.sumplit.samplecleankotlin.BuildConfig
import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.data.datasource.remote.network.NetworkService
import id.sumplit.samplecleankotlin.data.model.response.ListNewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RemoteDataSource() {

    private val service = NetworkService.createService()

    suspend fun getListNews(): Flow<ApiResponse<List<ListNewsResponse>>>{
        return flow {

            try {
                val response = service.getListNewsService(
                    apiKey = BuildConfig.API_KEY,
                    country = "us",
                    category = "business"
                )
                emit(ApiResponse.Success(response.articles ?:arrayListOf()))
            } catch (e: Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }
    }

    companion object {
        private val INSTANCE = RemoteDataSource()
        fun getInstance() = INSTANCE
    }
}