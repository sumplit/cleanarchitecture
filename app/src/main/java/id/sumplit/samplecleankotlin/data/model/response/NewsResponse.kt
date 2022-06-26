package id.sumplit.samplecleankotlin.data.model.response

import com.google.gson.annotations.SerializedName

data class ListNewsResponse(

    @SerializedName("source")
    val source: ListNewsSourceResponse?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("publishedAt")
    val publishedAt: String?,

    @SerializedName("content")
    val content: String?
)

data class ListNewsSourceResponse(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?
)
