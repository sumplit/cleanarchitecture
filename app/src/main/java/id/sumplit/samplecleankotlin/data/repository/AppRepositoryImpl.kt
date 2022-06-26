package id.sumplit.samplecleankotlin.data.repository

import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.data.datasource.remote.RemoteDataSource
import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.domain.entity.NewsModel
import id.sumplit.samplecleankotlin.domain.repository.AppRepository
import id.sumplit.samplecleankotlin.util.DataMapper.mapDataListNews
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource = RemoteDataSource.getInstance()
): AppRepository {

    override fun getListNews(): Flow<Resource<List<NewsModel>>> {
        return flow {
            emit(Resource.Loading())
            emitAll(remoteDataSource.getListNews().map {
                when (it){
                    is ApiResponse.Success -> {
                        Resource.Success(mapDataListNews(it.data))
                    }
                    is ApiResponse.Error -> {
                        Resource.Error(it.errorMessage)
                    }
                }
            })
        }
    }

    companion object {
        private val INSTANCE = AppRepositoryImpl()
        fun getInstance() = INSTANCE
    }

}