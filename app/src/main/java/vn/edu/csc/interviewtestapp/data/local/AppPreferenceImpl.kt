package vn.edu.csc.interviewtestapp.data.local

import android.content.Context
import com.google.gson.Gson
import javax.inject.Inject

class AppPreferenceImpl @Inject constructor(
    var context: Context,
    var gson: Gson
) : AppPreference {
    companion object {
        var KEY_DEVICE_ID: String = "KEY_DEVICE_ID"
        var KEY_TIME_CACHE_CONFIG: String = "KEY_TIME_CACHE_CONFIG"
    }

    private var sharedPreference =
        context.getSharedPreferences("vn.edu.csc.interviewtestapp", Context.MODE_PRIVATE)

    override fun setDeviceID(deviceID: String) {
        sharedPreference.edit().putString(KEY_DEVICE_ID, deviceID).apply()
    }

    override fun getDeviceID(): String? {
        return sharedPreference.getString(KEY_DEVICE_ID, "")
    }

    override fun setTimeCacheConfig(time: Long) {
        sharedPreference.edit().putLong(KEY_TIME_CACHE_CONFIG, time).apply()
    }

    override fun getTimeCacheConfig(): Long? {
        return sharedPreference.getLong(KEY_TIME_CACHE_CONFIG, 0)
    }
}