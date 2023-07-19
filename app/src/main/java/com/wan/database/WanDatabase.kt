package com.wan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/19 19:55
 * @Description:
 */
//entities = [Student::class,xxx::class]可以是多个表映射实体类
@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class WanDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    //单例
    companion object {
        private var INSTANCE: WanDatabase? = null
        fun initAppDatabase(context: Context): WanDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    WanDatabase::class.java, "wan.db"
                )
//                    .allowMainThreadQueries() //允许主线程操作数据库
                    .build()
            }
            return INSTANCE
        }

        fun instance(): WanDatabase? = INSTANCE
    }


}