package com.wan.mvp.inter.presenter

import android.content.Context
import com.wan.entity.User
import com.wan.mvp.inter.IBasePresenter

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:21
 * @Description:
 */
interface AuthPresenter: IBasePresenter {
    fun loginAction(context: Context, username: String, password: String)

    interface AuthCallback {
        fun loginSuccessCallBack(data: User)
        fun loginFailCallBack(msg: String)
    }
}