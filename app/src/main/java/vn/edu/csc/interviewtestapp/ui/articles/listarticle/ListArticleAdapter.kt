package vn.edu.csc.interviewtestapp.ui.articles.listarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.edu.csc.interviewtestapp.data.model.Article
import vn.edu.csc.interviewtestapp.databinding.ItemArticleBinding

class ListArticleAdapter(
    private val mListArticles: List<Article>,
    private val listener: (any: Any) -> Unit
) : RecyclerView.Adapter<ListArticleAdapter.ArticleVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemArticleBinding = ItemArticleBinding.inflate(layoutInflater)
        return ArticleVH(itemArticleBinding)
    }

    override fun getItemCount(): Int = mListArticles.size

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        holder.bind(mListArticles[position])
    }

    inner class ArticleVH(private val itemArticleBinding: ItemArticleBinding) :
        RecyclerView.ViewHolder(itemArticleBinding.root) {
        fun bind(article: Article) {
            itemArticleBinding.articleItem = article
            itemArticleBinding.executePendingBindings()
            listener.invoke(article)
        }
    }
}