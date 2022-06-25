package id.sumplit.samplecleankotlin.presentation.movielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.sumplit.samplecleankotlin.R

class NewsListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[NewsListViewModel::class.java]
        viewModel.loadListNews()

        setContentView(R.layout.activity_main)
    }
}