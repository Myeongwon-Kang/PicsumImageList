package com.kang6264.picsumimagelist.presentation.utils.rx

import io.reactivex.Scheduler


interface SchedulerProvider {
    fun computation(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler
}