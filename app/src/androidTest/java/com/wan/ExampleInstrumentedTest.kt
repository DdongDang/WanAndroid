package com.wan

import android.util.Log
import android.widget.Toast
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.wan.api.AuthApiService
import com.wan.entity.User
import com.wan.net.ApiServiceManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
private const val TAG = "ExampleInstrumentedTest"
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.wan", appContext.packageName)
    }

    @Test
    fun login() {
        val username = ""
        val password = ""
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        ApiServiceManager.instance.obtainService(AuthApiService::class.java)
            .login(username,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<User>() {
                override fun success(data: User) {
                    Log.d(TAG, "success: ${data.toString()}")
                }

                override fun fail(message: String) {
                    Log.d(TAG, "fail: $message")
                }
            })
    }
}