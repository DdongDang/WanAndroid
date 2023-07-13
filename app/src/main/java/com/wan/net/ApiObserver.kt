package com.wan
import android.util.Log
import com.wan.net.ApiResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
/**
 * @Author: LiuWenJi
 * @Date: 2023/7/13 20:01
 * @Description:
 */
private const val TAG = "ApiObserver"
abstract class ApiObserver<T> : Observer<ApiResponse<T>> {
    abstract fun success(data: T)

    abstract fun fail(message: String)

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: ApiResponse<T>) {
        Log.d(TAG, "onNext: 网络请求完毕")
        //简化版
        if (t.data == null){
            fail("登录失败，原因${t.errorMsg}")
        }else{
            success(t.data)
        }
    }

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {
        Log.d(TAG, "onNext: 网络请求异常：${e.message}")
        fail(e.message.toString())
    }
}