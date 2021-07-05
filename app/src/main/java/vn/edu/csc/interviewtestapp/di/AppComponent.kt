package vn.edu.csc.interviewtestapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.edu.csc.interviewtestapp.AppController
import vn.edu.csc.interviewtestapp.di.module.*
import javax.inject.Singleton

@Singleton
@Component
    (
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        LocalModule::class,
        ViewModelModule::class,
        RepoModule::class,
        ClientInterfaceModule::class,
        ActivityBindingModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<AppController> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}