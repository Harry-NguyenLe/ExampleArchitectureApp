package vn.edu.csc.interviewtestapp.utilities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import vn.edu.csc.interviewtestapp.data.local.AppPreference
import vn.edu.csc.interviewtestapp.data.model.DeviceInfo
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceInfoFactory @Inject constructor(
    context: Context,
    appPreference: AppPreference
) {
    private var uuid: UUID = getUUID(context, appPreference)
    private val deviceInfo: DeviceInfo = DeviceInfo(uuid.toString())

    @SuppressLint("HardwareIds")
    private fun getUUID(context: Context, appPreference: AppPreference): UUID {
        var uuid: UUID
        synchronized(DeviceInfoFactory::class) {
            try {
                val id = appPreference.getDeviceID()
                if (!TextUtils.isEmpty(id)) {
                    uuid = UUID.fromString(id)
                } else {
                    val androidID = Settings.Secure.getString(
                        context.contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                    uuid = if (!TextUtils.isEmpty(androidID)) {
                        UUID.nameUUIDFromBytes(androidID.toByteArray(Charsets.UTF_8))
                    } else {
                        val serial = Build.SERIAL
                        if (!TextUtils.isEmpty(serial)) {
                            UUID.nameUUIDFromBytes(
                                serial.toByteArray(Charsets.UTF_8)
                            )
                        } else {
                            UUID.randomUUID()
                        }
                    }
                }
            } catch (exception: Exception) {
                uuid = UUID.randomUUID()
            }
            appPreference.setDeviceID(uuid.toString())
        }
        return uuid
    }

    fun getDeviceInfo(): DeviceInfo {
        return deviceInfo
    }
}
