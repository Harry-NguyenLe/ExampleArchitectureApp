package vn.edu.csc.interviewtestapp.data.local

interface AppPreference {
    fun setDeviceID(deviceID: String)
    fun getDeviceID(): String?
    fun setTimeCacheConfig(time: Long)
    fun getTimeCacheConfig(): Long?
}