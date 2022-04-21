package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supsave.setOnClickListener {
            var name=supnamme.text.toString()
            var username=supusername.text.toString()
            var pass=suppassword.text.toString()
            var email=supemail.text.toString()
            var no=supphone.text.toString().toLong()
            var s1=Sup(name,username,pass,email,no)
            var db=DBHelper(this)
            var falg=db.insert(s1)
            if(falg)
            {
                Toast.makeText(this,"record inerted", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"record not inserted", Toast.LENGTH_LONG).show()
            }
        }
    }

}