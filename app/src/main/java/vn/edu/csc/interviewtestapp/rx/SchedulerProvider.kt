package vn.edu.csc.interviewtestapp.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}