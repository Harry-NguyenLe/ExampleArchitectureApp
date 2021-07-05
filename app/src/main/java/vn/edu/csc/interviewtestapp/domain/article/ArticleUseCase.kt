package vn.edu.csc.interviewtestapp.domain.article

import io.reactivex.Single
import vn.edu.csc.interviewtestapp.data.repo.ArticleRepo
import vn.edu.csc.interviewtestapp.data.response.ArticlesResponse
import vn.edu.csc.interviewtestapp.domain.base.SingleUseCase
import javax.inject.Inject

@Suppress("MemberVisibilityCanBePrivate")
class ArticleUseCase @Inject constructor(var articleRepo: ArticleRepo) :
    SingleUseCase<Unit, ArticlesResponse>() {

    override fun execute(param: Unit): Single<ArticlesResponse> {
        return articleRepo.fetchListArticles()
    }
}