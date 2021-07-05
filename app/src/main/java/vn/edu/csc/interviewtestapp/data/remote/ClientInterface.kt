package vn.edu.csc.interviewtestapp.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import vn.edu.csc.interviewtestapp.data.response.ArticlesResponse

interface ClientInterface {
    @GET("/example-feed/feed.json")
    fun fetchListArticles(): Single<ArticlesResponse>
}