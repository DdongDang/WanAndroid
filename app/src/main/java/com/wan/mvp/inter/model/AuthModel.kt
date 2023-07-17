package com.wan.mvp.inter.model

import android.content.Context
import com.wan.mvp.inter.presenter.AuthPresenter

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:14
 * @Description:定义了Model层的网络请求动作或者本地数据库动作
 */
interface AuthModel {
    /**
     * 取消网络请求
     */
    fun cancelRequest()

    /**
     * 登录
     */
    fun login(
        context: Context,
        username: String,
        password: String,
        actionListener: AuthPresenter.AuthCallback //P层的回调，把请求结果回调给P层
    )
}