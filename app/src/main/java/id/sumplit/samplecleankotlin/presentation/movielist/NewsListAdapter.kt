package id.sumplit.samplecleankotlin.presentation.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.sumplit.samplecleankotlin.databinding.ItemNewsBinding
import id.sumplit.samplecleankotlin.domain.model.NewsModel

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.ItemNews>() {

    val news = ArrayList<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemNews {
        val viewBinding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemNews(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemNews, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount() = news.size

    fun setDataChange(data: List<NewsModel>) {
        news.clear()
        news.addAll(data)
        notifyDataSetChanged()
    }

    inner class ItemNews(viewBinding: ItemNewsBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        private val binding = viewBinding
        fun bind(newsModel: NewsModel?) {
            binding.apply {
                tvTitle.text = newsModel?.title.orEmpty()
            }
        }
    }
}