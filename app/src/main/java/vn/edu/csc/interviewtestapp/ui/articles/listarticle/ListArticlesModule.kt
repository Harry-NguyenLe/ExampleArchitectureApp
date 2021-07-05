package vn.edu.csc.interviewtestapp.ui.articles.listarticle

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import vn.edu.csc.interviewtestapp.di.ViewModelKey
import vn.edu.csc.interviewtestapp.di.scope.FragmentScope

@Module
abstract class ListArticlesModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListArticleViewModel::class)
    abstract fun bindListArticleViewModel(listArticleViewModel: ListArticleViewModel): ViewModel

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindListArticleFragment(): ListArticleFragment
}