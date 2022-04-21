package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    signup.setOnClickListener {
        var intent=Intent(this,Signup::class.java)
        startActivity(intent)
    }
        btnlogin.setOnClickListener {
            var username=txtuname.text.toString()
            var pss=txtpass.text.toString()
            if(TextUtils.isEmpty(username) || TextUtils.isEmpty(pss))
            {
                Toast.makeText(applicationContext,
                    "Please Enter UserName/Password",
                    Toast.LENGTH_LONG).show()
            }
            else{
                var db = DBHelper(this)
                var arr=db.retriveall()
                for (arr1 in arr) {
                    if (username.equals("${arr1.sup_username}") && pss.equals("${arr1.sup_pass}")) {

                        var preference = getSharedPreferences("MyPref", MODE_PRIVATE)
                        var editor = preference.edit()
                        editor.putString("user", username)
                        editor.commit()

                        var intent = Intent(applicationContext, Signup::class.java)
                        startActivity(intent)
                        finish()
                    }

                }
               
            }
        }


    }
}