package com.neppplus.deliveryorderpractice_20211108.util

import android.app.Application
import android.content.Context

class Application : Application() {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: Application
        fun context(): Context {
            return instance.applicationContext
        }
    }

}