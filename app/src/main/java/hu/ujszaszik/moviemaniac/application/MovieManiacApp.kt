package hu.ujszaszik.moviemaniac.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hu.ujszaszik.moviemaniac.core.network.NetworkMonitor
import javax.inject.Inject

@HiltAndroidApp
class MovieManiacApp : Application() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate() {
        super.onCreate()
        networkMonitor.registerNetworkCallback()
    }
}