package vn.edu.csc.interviewtestapp.data.repo

import io.reactivex.Single
import vn.edu.csc.interviewtestapp.data.remote.ClientInterface
import vn.edu.csc.interviewtestapp.data.response.ArticlesResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepoImpl @Inject constructor(private var clientInterface: ClientInterface) : ArticleRepo {

    override fun fetchListArticles(): Single<ArticlesResponse> {
        return clientInterface.fetchListArticles()
    }
}