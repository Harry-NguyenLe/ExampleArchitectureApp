package vn.edu.csc.interviewtestapp.data.repo

import io.reactivex.Single
import vn.edu.csc.interviewtestapp.data.response.ArticlesResponse

interface ArticleRepo {
    fun fetchListArticles(): Single<ArticlesResponse>
}