package id.sumplit.samplecleankotlin.domain.repository

import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getListNews(): Flow<Resource<List<NewsModel>>>

}