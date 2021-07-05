package vn.edu.csc.interviewtestapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.edu.csc.interviewtestapp.di.scope.ActivityScope
import vn.edu.csc.interviewtestapp.ui.articles.ArticleActivity
import vn.edu.csc.interviewtestapp.ui.articles.detailarticle.DetailArticleModule
import vn.edu.csc.interviewtestapp.ui.articles.listarticle.ListArticlesModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            //fragment
            ListArticlesModule::class,
            DetailArticleModule::class
        ]
    )
    abstract fun contributeArticleActivity(): ArticleActivity

}