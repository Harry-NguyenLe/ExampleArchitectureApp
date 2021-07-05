package vn.edu.csc.interviewtestapp.ui.articles.detailarticle

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import vn.edu.csc.interviewtestapp.di.ViewModelKey
import vn.edu.csc.interviewtestapp.di.scope.FragmentScope

@Module
abstract class DetailArticleModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailArticleViewModel::class)
    abstract fun bindListArticleViewModel(detailArticleViewModel: DetailArticleViewModel): ViewModel

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailArticleFragment(): DetailArticleFragment
}