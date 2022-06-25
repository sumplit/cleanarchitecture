package id.sumplit.samplecleankotlin.data.remote.response

import com.google.gson.annotations.SerializedName

data class BaseApiResponse<DataType>(

    @SerializedName("status")
    val status: String?,

    @SerializedName("totalResults")
    val totalResults: Int? = 0,

    @SerializedName("articles")
    val articles: DataType?
)
