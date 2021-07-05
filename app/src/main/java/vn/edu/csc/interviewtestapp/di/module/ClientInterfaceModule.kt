package vn.edu.csc.interviewtestapp.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import vn.edu.csc.interviewtestapp.data.remote.ClientInterface
import javax.inject.Singleton

@Module
class ClientInterfaceModule {

    @Singleton
    @Provides
    fun clientInterface(retrofit: Retrofit): ClientInterface {
        return retrofit.create(ClientInterface::class.java)
    }

}