package com.personal.techugoassignment.application

import android.app.Application

class TechugoApplication: Application() {

    companion object {
        lateinit var instance: TechugoApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }
}