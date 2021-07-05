package vn.edu.csc.interviewtestapp.data.remote

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockInterceptor @Inject constructor(var gson: Gson) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url: String = chain.request().url.toUri().toString()
        return if (isMockApi(url)) {
            val responseString = getResponseString(url)
            chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .body(responseString.toResponseBody("application/json".toMediaTypeOrNull()))
                .message(responseString)
                .build()
        } else {
            chain.proceed(chain.request())
        }
    }

    private fun isMockApi(url: String): Boolean {
        return url.endsWith("mock")
    }

    private fun getResponseString(url: String): String {
        when (getUrlType(url)) {
            "listArticle" -> return ""
            else -> throw IllegalAccessError("Not support url $url")
        }
    }

    private fun getUrlType(url: String): String {
        if (!isMockApi(url)) {
            throw IllegalArgumentException("Not support with no testing")
        }
        var i = url.lastIndexOf("/")
        if (i < 0) {
            throw java.lang.IllegalArgumentException("Url is invalid")
        }
        val realUrl = url.substring(0, i)
        i = realUrl.lastIndexOf("/")
        if (i < 0) {
            throw java.lang.IllegalArgumentException("Url is invalid")
        }
        return realUrl.substring(i + 1)
    }
}
