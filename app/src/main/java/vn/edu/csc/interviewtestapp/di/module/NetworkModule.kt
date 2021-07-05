package vn.edu.csc.interviewtestapp.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.edu.csc.interviewtestapp.data.remote.AppInterceptor
import vn.edu.csc.interviewtestapp.data.remote.MockInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideCache(context: Context): Cache {
        return Cache(context.cacheDir, 10 * 1024 * 1024)
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideMockInterceptor(gson: Gson): MockInterceptor {
        return MockInterceptor(gson)
    }

    @Singleton
    @Provides
    fun provideAppOkHttpClient(
        cache: Cache,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        mockInterceptor: MockInterceptor,
        appInterceptor: AppInterceptor
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.apply {
            cache(cache)
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(mockInterceptor)
            addInterceptor(appInterceptor)
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
        }
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideAppRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient,
        @Named(Qualifiers.ENVIRONMENT) environment: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(environment)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}