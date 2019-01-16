package com.a4nt0n64r.socialnetwork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun isFieldEmpty(field: EditText) = field.text.isEmpty()
        fun isCredentialsCorrect(login: EditText, passwd: EditText): Boolean {
            return (login.text.toString() == R.string.credentials.toString()) &&
                    (passwd.text.toString() == R.string.credentials.toString())
        }

        login_button.setOnClickListener {
            if (isFieldEmpty(login_textView) && !isFieldEmpty(passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.empty_login,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (!isFieldEmpty(login_textView) && isFieldEmpty(passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.empty_password,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (isFieldEmpty(login_textView) && isFieldEmpty(passwd_textView)) {
                Snackbar.make(
                    constr,
                    R.string.empty_data,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (isCredentialsCorrect(login_textView,passwd_textView)) {
                //старт news activity
            }
        }
    }
}
