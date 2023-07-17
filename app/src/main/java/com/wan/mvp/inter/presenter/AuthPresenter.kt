package com.wan.mvp.inter.presenter

import android.content.Context
import com.wan.entity.User

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:21
 * @Description:
 */
interface AuthPresenter {
    fun loginAction(context: Context, username: String, password: String)

    interface AuthCallback {
        fun loginFailCallBack(data: User)
        fun loginSuccessCallBack(msg: String)
    }
}