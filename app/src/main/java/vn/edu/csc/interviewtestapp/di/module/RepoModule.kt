package vn.edu.csc.interviewtestapp.di.module

import dagger.Binds
import dagger.Module
import vn.edu.csc.interviewtestapp.data.repo.ArticleRepo
import vn.edu.csc.interviewtestapp.data.repo.ArticleRepoImpl
import javax.inject.Singleton

@Module
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun articleRepo(articleRepoImpl: ArticleRepoImpl): ArticleRepo

}