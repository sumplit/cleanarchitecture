package id.sumplit.samplecleankotlin.domain.usecase

import id.sumplit.samplecleankotlin.data.repository.AppRepositoryImpl
import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.data.datasource.remote.network.ApiResponse
import id.sumplit.samplecleankotlin.domain.entity.NewsModel
import id.sumplit.samplecleankotlin.domain.repository.AppRepository
import id.sumplit.samplecleankotlin.util.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class AppUseCaseImpl(
    private val repository: AppRepository = AppRepositoryImpl.getInstance()
) : AppUseCase {

    override fun getListNews(): Flow<Resource<List<NewsModel>>> {
        return flow {
            emit(Resource.Loading())
            emitAll(repository.getListNews().map {
                when (it){
                    is ApiResponse.Success -> {
                        Resource.Success(
                            DataMapper.mapDataListNews(
                                it.data
                            )
                        )
                    }
                    is ApiResponse.Error -> {
                        Resource.Error(it.errorMessage)
                    }
                }
            })

        }
    }

    companion object {
        private val INSTANCE = AppUseCaseImpl()
        fun getInstance() = INSTANCE
    }
}