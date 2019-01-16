package com.a4nt0n64r.socialnetwork

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
            Log.d("STR",(login.text.toString() == R.string.credentials.toString()).toString())
            Log.d("STR",passwd.text.toString())
            return ((login.text.toString() == R.string.credentials.toString()) and
                    (passwd.text.toString() == R.string.credentials.toString()))
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
                //старт news activity
            }
        }
    }
}
