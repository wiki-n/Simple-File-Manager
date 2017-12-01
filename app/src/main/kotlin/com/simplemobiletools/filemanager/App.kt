package com.simplemobiletools.filemanager

import android.app.Application
import com.github.ajalt.reprint.core.Reprint
import com.simplemobiletools.commons.extensions.checkUseEnglish
import com.simplemobiletools.filemanager.BuildConfig.USE_LEAK_CANARY
import com.squareup.leakcanary.LeakCanary

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (USE_LEAK_CANARY) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            LeakCanary.install(this)
        }

        checkUseEnglish()
        Reprint.initialize(this)
    }
}
