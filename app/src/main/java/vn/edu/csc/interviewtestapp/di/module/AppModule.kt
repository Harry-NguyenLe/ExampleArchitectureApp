package vn.edu.csc.interviewtestapp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import vn.edu.csc.interviewtestapp.MainConfig
import vn.edu.csc.interviewtestapp.rx.AppSchedulerProvider
import vn.edu.csc.interviewtestapp.rx.SchedulerProvider
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    @Named(Qualifiers.ENVIRONMENT)
    fun provideDomainURL(): String {
        return when (MainConfig.env) {
            MainConfig.ENV.DEV -> MainConfig.DEV_DOMAIN_URL
            MainConfig.ENV.TEST -> MainConfig.TEST_DOMAIN_URL
            MainConfig.ENV.SANDBOX -> MainConfig.SANDBOX_DOMAIN_URL
            MainConfig.ENV.STAGING -> MainConfig.STAGING_DOMAIN_URL
            MainConfig.ENV.PRODUCTION -> MainConfig.PRODUCTION_DOMAIN_URL
        }
    }

}