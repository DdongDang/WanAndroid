package com.wan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/19 17:53
 * @Description:
 */
@Entity
class Student {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "uname")
    var name: String = ""

    @ColumnInfo
    var age: Int = 0


    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age)"
    }
}