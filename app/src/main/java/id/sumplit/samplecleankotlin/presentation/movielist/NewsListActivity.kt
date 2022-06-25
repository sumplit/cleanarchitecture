package id.sumplit.samplecleankotlin.presentation.movielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.sumplit.samplecleankotlin.data.Resource
import id.sumplit.samplecleankotlin.databinding.ActivityNewsBinding

class NewsListActivity : AppCompatActivity() {

    private lateinit var mActivityNewsBinding: ActivityNewsBinding
    private val mAdapteNews by lazy { NewsListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityNewsBinding = ActivityNewsBinding.inflate(layoutInflater)

        setContentView(mActivityNewsBinding.root)

        mActivityNewsBinding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@NewsListActivity, LinearLayoutManager.VERTICAL, false)
                adapter = mAdapteNews
        }

        setViewModel()
    }

    private fun setViewModel() {
        val viewModel = ViewModelProvider(this)[NewsListViewModel::class.java]
        viewModel.apply {
            loadListNews()

            listNews.observe(this@NewsListActivity) {
                when (it) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        (mActivityNewsBinding.rvNews.adapter as NewsListAdapter).setDataChange(it.data?: emptyList())
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }
    }

}