package com.example.danai.room_tester4

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TestDialogFragment:DialogFragment() {

    var onClickTest:OnClickTest? = null
    var mCtx:Context = MainApplication.applicationContext()
    var mCtx2:Context = MainApplication()
    interface OnClickTest{
        fun onClickTest()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_main,container,false)
        onClickTest = mCtx2 as OnClickTest
        return view
    }
}