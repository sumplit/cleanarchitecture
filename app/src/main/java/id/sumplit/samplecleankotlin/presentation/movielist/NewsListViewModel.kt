package id.sumplit.samplecleankotlin.presentation.movielist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.domain.model.NewsModel
import id.sumplit.samplecleankotlin.domain.usecase.AppUseCase
import id.sumplit.samplecleankotlin.domain.usecase.AppUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsListViewModel(
    private val useCase: AppUseCase = AppUseCaseImpl.getInstance()
    ) : ViewModel() {

    private val _listNews = MutableLiveData<Resource<List<NewsModel>>>()
    val listNews = Transformations.map(_listNews) { it }

    fun loadListNews(){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getListNews().collect {
                _listNews.postValue(it)
            }
        }
    }
}