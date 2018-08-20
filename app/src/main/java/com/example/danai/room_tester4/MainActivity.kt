package com.example.danai.room_tester4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.e
import android.widget.Toast
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appDatabase = AppDatabase.getAppDatabase(this)
        val scoopsStudent = StudentEntity()
        scoopsStudent.code = 1111
        scoopsStudent.email = "20scoops@gmail.com"
        scoopsStudent.firstName = "20scoops"
        scoopsStudent.lastName = "CNX"
        scoopsStudent.address = "110/4 Moo 5, Canal Road, Suthep, Muang Chiang Mai, Chiang Mai 50200"
        scoopsStudent.age = 20

        Flowable.fromCallable { appDatabase.studentDao().insertStudent(scoopsStudent) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { Log.e("HHH", "insert complete") }

//        appDatabase.studentDao().getStudentByCodeRX(1111)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {Log.e("showdata", it[0].age.toString())},
//                        {error -> Log.e("Error",error.message)})

//        val bigTeacher = TeacherEntity()
//        bigTeacher.code = 111
//        bigTeacher.firstName = "Big"
//        bigTeacher.lastName = "Teacher"
//        bigTeacher.gender = "Male"

//        appDatabase.studentDao().insertStudent(scoopsStudent)

//        Flowable.fromCallable { appDatabase.teacherDao().insertTeacher(bigTeacher) }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({result->e("result",result.toString())})
//                {throwable-> e("THROW",throwable.message)}
//
//        Flowable.fromCallable { appDatabase.studentDao().getStudentAll() }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({user-> e("teacher",user.toString())})
//                {throwable->
//                    e("STUDENT_THROW",throwable.message)
//                }
//
//        Flowable.fromCallable { appDatabase.teacherDao().getTeacherAll() }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({user-> e("teacher",user.toString())})
//                {throwable->
//                    e("TEACHER_THROW",throwable.message)
//                }

//        appDatabase.studentDao().getStudentByCodeRX_Observe(1234567892)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({Log.e("showdata",it.get(0).address)},
//                        {error -> Log.e("Error",error.message)})



    }
}
