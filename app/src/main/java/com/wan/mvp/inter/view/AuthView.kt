package com.wan.mvp.inter.view

import com.wan.entity.User

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 15:20
 * @Description: 把结果显示到Activity或者Fragment
 */
interface AuthView {
    fun loginSuccess(data: User)
    fun loginFailure(msg: String)
}