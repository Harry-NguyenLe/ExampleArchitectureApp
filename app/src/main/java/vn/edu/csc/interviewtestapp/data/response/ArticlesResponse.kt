package vn.edu.csc.interviewtestapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.edu.csc.interviewtestapp.data.model.Article

data class ArticlesResponse(
    @SerializedName("articles")
    @Expose
    var listArticle: List<Article>
)