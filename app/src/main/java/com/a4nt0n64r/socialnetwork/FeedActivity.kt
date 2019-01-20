package com.a4nt0n64r.socialnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        fun onNavigationItemSelected(menu: BottomNavigationView): Boolean {
            val item = menu.selectedItemId
            when (item) {
                R.id.menu_feed -> Log.d("test", "you push feed button")
                R.id.menu_news -> Log.d("test", "you push news button")
                R.id.menu_notifications -> Log.d("test", "you push notifications button")
            }
            return true
        }

        navigation.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(navigation)
        }
    }
}
