package com.wan.mvp.impl.presenter

import android.content.Context
import com.AuthModelImpl
import com.wan.entity.User
import com.wan.mvp.impl.view.LoginActivity
import com.wan.mvp.inter.model.AuthModel
import com.wan.mvp.inter.presenter.AuthPresenter

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:58
 * @Description:Presenter层的实现，持有View层引用更新UI，持有Model层引用请求数据
 */
class AuthPresenterImpl(val authView: LoginActivity) : AuthPresenter, AuthPresenter.AuthCallback {
    private val authModel: AuthModel = AuthModelImpl()
    override fun loginAction(context: Context, username: String, password: String) {
        authModel.login(context, username, password, this)
    }

    override fun loginSuccessCallBack(data: User) {
        authView.loginSuccess(data)
    }

    override fun loginFailCallBack(msg: String) {
        authView.loginFailure(msg)
    }
}