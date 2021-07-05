package vn.edu.csc.interviewtestapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import vn.edu.csc.interviewtestapp.rx.SchedulerProvider

abstract class BaseViewModel(application: Application, var schedulerProvider: SchedulerProvider) :
    AndroidViewModel(application) {
    val compositeDisposable = CompositeDisposable()

    fun dispose(disposable: Disposable) {
        disposable.let {
            disposable.dispose()
        }
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}