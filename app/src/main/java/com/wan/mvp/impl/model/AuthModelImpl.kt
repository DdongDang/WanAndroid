package com


import android.content.Context
import android.util.Log
import com.wan.ApiObserver
import com.wan.api.AuthApiService
import com.wan.entity.User
import com.wan.mvp.inter.model.AuthModel
import com.wan.mvp.inter.presenter.AuthPresenter
import com.wan.net.ApiServiceManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:33
 * @Description:
 */
private const val TAG = "AuthModelImpl"

class AuthModelImpl : AuthModel {
    override fun cancelRequest() {

    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        actionListener: AuthPresenter.AuthCallback
    ) {
        ApiServiceManager.instance.obtainService(AuthApiService::class.java)
            .login(username, password)
            .subscribeOn(Schedulers.io()) //给上面的那请求分配异步线程
            .observeOn(AndroidSchedulers.mainThread()) //给下面更新操作分配Main线程
            .subscribe(object : ApiObserver<User>() {
                override fun success(data: User) {
                    Log.d(TAG, "success: $data")
                    actionListener.loginSuccessCallBack(data)
                }

                override fun fail(message: String) {
                    Log.d(TAG, "fail:登录失败--$message ")
                    actionListener.loginFailCallBack(message)
                }
            })
    }
}