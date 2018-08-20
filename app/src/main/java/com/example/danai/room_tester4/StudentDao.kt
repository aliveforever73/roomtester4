package com.example.danai.room_tester4

import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(studentEntity: StudentEntity)

    @Update()
    fun updateStudent(studentEntity: StudentEntity)

    @Query("UPDATE student SET age = :ageStudent WHERE student_code = :studentCode")
    fun updateStudentAge(ageStudent:Int,studentCode: Int)

    @Delete
    fun deleteStudent(studentEntity: StudentEntity)

    @Query("SELECT * FROM student")
    fun getStudentAll(): List<StudentEntity>

    @Query("SELECT * FROM student WHERE student.student_code = :studentCode")
    fun getStudentByCode(studentCode: Int): List<StudentEntity>

    @Query("SELECT * FROM student WHERE student.student_code = :studentCode")
    fun getStudentByCodeRX(studentCode: Int): Flowable<List<StudentEntity>>

    @Query("SELECT * FROM student WHERE student.email LIKE :email")
    fun getStudentByEmail(email: String): StudentEntity

    @Query("DELETE FROM student")
    fun deleteTable()
}