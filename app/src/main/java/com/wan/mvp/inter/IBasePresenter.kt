package com.wan.mvp.inter

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 16:59
 * @Description:P层的base，做一些释放资源的工作，避免内存泄露
 */
interface IBasePresenter {
    //视图层持有P层，为避免内存泄露，要在视图层销毁的时候释放资源
    fun unAttachView()
}