package vn.edu.csc.interviewtestapp.domain.base

import io.reactivex.Single

abstract class SingleUseCase<P, R> {
    abstract fun execute(param: P): Single<R>
}