package com.wan

import android.app.Application
import com.wan.database.WanDatabase

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/19 20:22
 * @Description:
 */
class WanApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        WanDatabase.initAppDatabase(this)
    }
}