package vn.edu.csc.interviewtestapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article(
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("pubDate")
    @Expose
    var pubDate: String,
    @SerializedName("dc:creator")
    @Expose
    var dcCreator: String,
    @SerializedName("category")
    @Expose
    var category: List<String>,
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("image")
    @Expose
    var image: String,
    @SerializedName("detail")
    @Expose
    var detail: String
) : Serializable
