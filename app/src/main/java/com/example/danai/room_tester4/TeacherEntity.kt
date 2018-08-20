package com.example.danai.room_tester4

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "teacher")
data class TeacherEntity(@PrimaryKey(autoGenerate = true) var id: Int? = null,
                         @ColumnInfo(name = "teacher_code") var code: Long? = null,
                         @ColumnInfo(name = "first_name") var firstName: String? = null,
                         @ColumnInfo(name = "last_name") var lastName: String? = null,
                         var gender: String? = null)