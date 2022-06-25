package id.sumplit.samplecleankotlin.domain.usecase

import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface AppUseCase {

    fun getListNews(): Flow<Resource<List<NewsModel>>>
}