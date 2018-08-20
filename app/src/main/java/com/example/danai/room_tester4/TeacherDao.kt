package com.example.danai.room_tester4

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TeacherDao {
    @Insert
    fun insertTeacher(teacherEntity: TeacherEntity)

    @Query("SELECT * FROM teacher")
    fun getTeacherAll(): List<TeacherEntity>
}