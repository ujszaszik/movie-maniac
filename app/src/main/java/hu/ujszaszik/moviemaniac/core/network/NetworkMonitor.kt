package hu.ujszaszik.moviemaniac.core.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import hu.ujszaszik.moviemaniac.util.dec
import hu.ujszaszik.moviemaniac.util.inc
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkMonitor @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val networkRequest: NetworkRequest
) {

    companion object {
        @JvmStatic
        @Volatile
        private var isConnected: AtomicBoolean = AtomicBoolean(false)

        fun isConnected(): Boolean = isConnected.get()
    }

    fun registerNetworkCallback() {
        connectivityManager.registerNetworkCallback(networkRequest, getNetworkCallback())
    }

    private fun getNetworkCallback(): ConnectivityManager.NetworkCallback {
        return object : ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                super.onLost(network)
                isConnected--
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                isConnected++
            }
        }
    }
}