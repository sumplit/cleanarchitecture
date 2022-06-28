package id.sumplit.samplecleankotlin.data

sealed class Resource<out T> {
    class Success<T>(val data: T?) : Resource<T>()
    class Error(val message: String, val exception: Exception? = null) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}