package vn.edu.csc.interviewtestapp.ui.articles.listarticle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list_articles.*
import vn.edu.csc.interviewtestapp.R
import vn.edu.csc.interviewtestapp.data.model.Article
import vn.edu.csc.interviewtestapp.di.DaggerViewModelFactory
import vn.edu.csc.interviewtestapp.ui.base.BaseFragment
import javax.inject.Inject

class ListArticleFragment : BaseFragment() {

    @Inject
    lateinit var factory: DaggerViewModelFactory

    private lateinit var listArticleAdapter: ListArticleAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var viewModel: ListArticleViewModel
    private var listArticles = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(ListArticleViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initControls()
        observeVM()
    }

    private fun initControls() {
        listArticleAdapter = ListArticleAdapter(listArticles) { article ->
            navigateDetailArticle(article as Article)
        }
        linearLayoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
    }

    private fun applyRecyclerView() {
        rvListArticles.apply {
            adapter = listArticleAdapter
            layoutManager = linearLayoutManager
        }
    }

    private fun observeVM() {
        viewModel.fetchShowListArticles().observe(viewLifecycleOwner, Observer {
            listArticles.clear()
            listArticles.addAll(it)
            applyRecyclerView()
        })

        viewModel.getShowErrorMessage().observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun navigateDetailArticle(article: Article) {
        val navDirections = ListArticleFragmentDirections
            .actionListArticleFragmentToDetailArticleFragment(article)
        getNavController().navigate(navDirections)
    }
}