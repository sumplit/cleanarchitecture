package id.sumplit.samplecleankotlin.domain.repository

import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.data.model.response.ListNewsResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getListNews(): Flow<ApiResponse<List<ListNewsResponse>>>

}