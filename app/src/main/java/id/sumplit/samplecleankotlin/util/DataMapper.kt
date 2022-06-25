package id.sumplit.samplecleankotlin.util

import id.sumplit.samplecleankotlin.data.remote.response.ListNewsResponse
import id.sumplit.samplecleankotlin.domain.model.NewsModel

object DataMapper {

    fun mapDataListNews(data: List<ListNewsResponse>?): List<NewsModel> {
        return data?.map { mapDataNews(it) } ?: emptyList()
    }

    private fun mapDataNews(data: ListNewsResponse): NewsModel {
        return NewsModel(
            author = data.author.orEmpty(),
            title = data.title.orEmpty(),
            description = data.description.orEmpty(),
            image = data.urlToImage.orEmpty(),
            publishedAt = data.publishedAt.orEmpty(),
            content = data.content.orEmpty()
        )
    }
}