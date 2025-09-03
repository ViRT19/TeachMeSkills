package by.alerus.destinumber

import android.app.Application
import by.alerus.destinumber.di.appModule
import by.alerus.destinumber.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DestiNumberApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DestiNumberApp)
            modules(appModule, networkModule)
        }
    }
} 