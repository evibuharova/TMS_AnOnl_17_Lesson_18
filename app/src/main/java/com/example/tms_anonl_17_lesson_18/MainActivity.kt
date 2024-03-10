package com.example.tms_anonl_17_lesson_18

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private var edName: EditText? = null
    private  var edPassword: EditText? = null
    private var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edName = findViewById(R.id.editName)
        edPassword = findViewById(R.id.editPassword)
        btnLogin = findViewById(R.id.loginBtn)
        btnLogin?.setOnClickListener {
            if (validate()) {
                goToNextPage()
            }
        }
    }
    private fun validate(): Boolean {
       //извалид переменная для запоминанания ошибок и возможности проверять
        // и логин и пароль одновременно
        var isvalid=true
        val loginText=edName?.text
        val passwordText=edPassword?.text
        if (loginText == null || loginText.length < 6) {
            edName?.error="Password must be more then six symbols"
            isvalid=false
        }
        if (passwordText == null || passwordText.length < 6) {
            edPassword?.error="Password must be more then six symbols"
            isvalid=false
        }
        return isvalid
    }
//переход на следующую страницу
    private fun goToNextPage() {
        val intent=Intent(this, Activity2::class.java)
    //добавлены в интент имя и значение едиттекста (имя и пароль)
        intent.putExtra("Login",edName?.text?.toString())
        intent.putExtra("Password",edPassword?.text?.toString())
        startActivity(intent)

    }
}