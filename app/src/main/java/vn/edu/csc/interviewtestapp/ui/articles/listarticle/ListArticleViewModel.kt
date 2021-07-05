package vn.edu.csc.interviewtestapp.ui.articles.listarticle

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vn.edu.csc.interviewtestapp.data.model.Article
import vn.edu.csc.interviewtestapp.data.response.ArticlesResponse
import vn.edu.csc.interviewtestapp.domain.article.ArticleUseCase
import vn.edu.csc.interviewtestapp.rx.SchedulerProvider
import vn.edu.csc.interviewtestapp.ui.base.BaseViewModel
import javax.inject.Inject

class ListArticleViewModel @Inject constructor(
    application: Application,
    schedulerProvider: SchedulerProvider,
    private var articleUseCase: ArticleUseCase
) : BaseViewModel(application, schedulerProvider) {

    private val listArticles = MutableLiveData<List<Article>>()
    private val errorMessage = MutableLiveData<String>()

    init {
        loadListArticles()
    }

    private fun loadListArticles() {
        with(compositeDisposable) {
            add(
                articleUseCase.execute(Unit)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribe { t1: ArticlesResponse?, t2: Throwable? ->
                        handlingArticleResponse(articlesResponse = t1)
                        handlingThrowable(throwable = t2)
                    }
            )
        }
    }

    private fun handlingArticleResponse(articlesResponse: ArticlesResponse?) {
        listArticles.postValue(articlesResponse?.listArticle)
    }

    private fun handlingThrowable(throwable: Throwable?) {
        errorMessage.postValue(throwable?.message)
    }

    fun fetchShowListArticles(): LiveData<List<Article>> = listArticles

    fun getShowErrorMessage(): LiveData<String> = errorMessage
}