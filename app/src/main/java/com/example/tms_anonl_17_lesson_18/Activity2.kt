package com.example.tms_anonl_17_lesson_18

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    private var activityTwoText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        activityTwoText = findViewById(R.id.activityTwoText)
        getData()
    }
    private fun getData() {
        //получение имени и пароля и вывод их на экран
       var login=intent.extras?.getString("Login")
        var password=intent.extras?.getString("Password")
        activityTwoText?.text="Login: " + login+"\n"+"Password: "+password
    }

}