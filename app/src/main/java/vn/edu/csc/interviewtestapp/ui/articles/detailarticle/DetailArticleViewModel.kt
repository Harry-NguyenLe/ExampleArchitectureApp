package vn.edu.csc.interviewtestapp.ui.articles.detailarticle

import android.app.Application
import androidx.lifecycle.MutableLiveData
import vn.edu.csc.interviewtestapp.data.model.Article
import vn.edu.csc.interviewtestapp.rx.SchedulerProvider
import vn.edu.csc.interviewtestapp.ui.base.BaseViewModel
import javax.inject.Inject

class DetailArticleViewModel @Inject constructor(
    application: Application,
    schedulerProvider: SchedulerProvider
) : BaseViewModel(application, schedulerProvider) {

    var article = MutableLiveData<Article>()

    fun setArticle(article: Article) {
        this.article.value = article
    }
}