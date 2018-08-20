package com.example.danai.room_tester4

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.Context

@Database(entities = arrayOf(StudentEntity::class,TeacherEntity::class),version = 3)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private val MIGRATION_1_to_2: Migration = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN age INTEGER")
            }

        }
        private val MIGRATION_2_to_3: Migration = object :Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE teacher (teacher_code INT,first_name TEXT,last_name TEXT,gender TEXT)")
            }
        }
        fun getAppDatabase(context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, "db_app")
                        .addMigrations(MIGRATION_1_to_2,
                                MIGRATION_2_to_3).build()
    }

    abstract fun studentDao(): StudentDao
    abstract fun teacherDao(): TeacherDao
}