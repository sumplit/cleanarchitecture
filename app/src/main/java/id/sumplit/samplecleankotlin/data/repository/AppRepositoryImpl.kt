package id.sumplit.samplecleankotlin.data.repository

import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.data.datasource.remote.RemoteDataSource
import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.data.model.response.ListNewsResponse
import id.sumplit.samplecleankotlin.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource = RemoteDataSource.getInstance()
): AppRepository {

    override suspend fun getListNews(): Flow<ApiResponse<List<ListNewsResponse>>> {
        return remoteDataSource.getListNews()
    }

    companion object {
        private val INSTANCE = AppRepositoryImpl()
        fun getInstance() = INSTANCE
    }

}