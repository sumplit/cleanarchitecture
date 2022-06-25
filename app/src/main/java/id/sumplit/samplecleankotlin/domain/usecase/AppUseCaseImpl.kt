package id.sumplit.samplecleankotlin.domain.usecase

import id.sumplit.samplecleankotlin.data.AppRepositoryImpl
import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.domain.model.NewsModel
import id.sumplit.samplecleankotlin.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class AppUseCaseImpl(
    private val repository: AppRepository = AppRepositoryImpl.getInstance()
) : AppUseCase {

    override fun getListNews(): Flow<Resource<List<NewsModel>>> =
        repository.getListNews()

    companion object {
        private val INSTANCE = AppUseCaseImpl()
        fun getInstance() = INSTANCE
    }
}