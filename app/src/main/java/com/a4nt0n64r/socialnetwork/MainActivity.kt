package com.a4nt0n64r.socialnetwork

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
//import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun isFieldEmpty(field: EditText) = field.text.isEmpty()
        fun isCredentialsCorrect(login: EditText, passwd: EditText): Boolean {
            return ((login.text.toString() == getString(R.string.credentials)) and
                    (passwd.text.toString() == getString(R.string.credentials)))
        }

        login_button.setOnClickListener {
            if (isFieldEmpty(login_textView) and !isFieldEmpty(passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.empty_login,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (!isFieldEmpty(login_textView) and isFieldEmpty(passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.empty_password,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (isFieldEmpty(login_textView) and isFieldEmpty(passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.empty_data,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (!isCredentialsCorrect(login_textView,passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.incorrect_credentials,
                    Snackbar.LENGTH_SHORT
                ).show()
            }else{
                val intent = Intent(this,FeedActivity::class.java)
                startActivity(intent)
            }
        }

        listOf(34,"hello")
    }
}
