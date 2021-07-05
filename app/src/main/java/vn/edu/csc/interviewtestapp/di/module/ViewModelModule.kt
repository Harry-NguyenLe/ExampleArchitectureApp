package vn.edu.csc.interviewtestapp.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import vn.edu.csc.interviewtestapp.di.DaggerViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}