package id.sumplit.samplecleankotlin.domain.repository

import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.data.model.response.ListNewsResponse

interface AppRepository {

    suspend fun getListNews(): ApiResponse<List<ListNewsResponse>>

}