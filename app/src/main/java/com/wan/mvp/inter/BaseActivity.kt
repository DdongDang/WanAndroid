package com.wan.mvp.inter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/17 17:06
 * @Description:BaseActivity，抽离Activity一些通用方法
 */
private const val TAG = "BaseActivity"
abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {
    lateinit var presenter: P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: 开始初始化基类")
        setContentView(layoutRes)
        presenter = createP()
        initView()
    }

    abstract val layoutRes: Int
    abstract fun initView()

    /**
     * 初始化P层引用
     */
    abstract fun createP(): P

    override fun onDestroy() {
        super.onDestroy()
        recycleP()
    }

    /**
     * 释放P层相关资源
     */
    abstract fun recycleP()
}