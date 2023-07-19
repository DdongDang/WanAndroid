package com.wan.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * @Author: LiuWenJi
 * @Date: 2023/7/19 17:59
 * @Description:
 */
@Dao
interface StudentDao {
    @Insert
    fun insertStudent(vararg students: Student)

    @Update
    fun updateStudents(vararg students: Student)

    @Delete
    fun deleteStudent( student: Student)

    @Query("DELETE FROM student")
    fun deleteAllStudent()

    @Query("SELECT * FROM student ORDER BY id DESC ")
    fun queryAllStudent():List<Student>
}