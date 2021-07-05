package vn.edu.csc.interviewtestapp.data.remote

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import vn.edu.csc.interviewtestapp.data.local.AppPreference
import vn.edu.csc.interviewtestapp.data.model.DeviceInfo
import vn.edu.csc.interviewtestapp.utilities.DeviceInfoFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppInterceptor @Inject constructor(
    context: Context,
    appPreference: AppPreference
) : Interceptor {
    companion object {
        const val HEADER_TOKEN = "X-Token"
        const val HEADER_DEVICE_ID = "X-DeviceID"
        const val HEADER_DEVICE_OS = "X-DeviceOS"
        const val HEADER_REQUEST_TIME = "X-RequestTime"
        const val HEADER_PHONE_NUMBER = "X-PhoneNo"
    }

    private var deviceInfo: DeviceInfo = DeviceInfoFactory(context, appPreference).getDeviceInfo()
    private lateinit var token: String

    override fun intercept(chain: Interceptor.Chain): Response {
        val timeRequest: String = System.currentTimeMillis().toString()
        var request: Request = chain.request()
        request.header(HEADER_PHONE_NUMBER)
        request = request.newBuilder()
            .addHeader(HEADER_TOKEN, token)
            .addHeader(HEADER_REQUEST_TIME, timeRequest)
            .addHeader(HEADER_DEVICE_ID, deviceInfo.deviceID)
            .addHeader(HEADER_DEVICE_OS, deviceInfo.os)
            .build()
        return chain.proceed(request)
    }

    fun updateToken(token: String) {
        this.token = token
    }
}