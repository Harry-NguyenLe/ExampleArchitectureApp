package vn.edu.csc.interviewtestapp.di.module

import dagger.Binds
import dagger.Module
import vn.edu.csc.interviewtestapp.data.local.AppPreference
import vn.edu.csc.interviewtestapp.data.local.AppPreferenceImpl
import javax.inject.Singleton

@Module
abstract class LocalModule {
    @Singleton
    @Binds
    abstract fun bindAppPreference(appPreferenceImpl: AppPreferenceImpl): AppPreference
}