package com.a4nt0n64r.socialnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.a4nt0n64r.socialnetwork.Feed.NewsAndNotification
import com.a4nt0n64r.socialnetwork.Feed.NewsElement
import com.a4nt0n64r.socialnetwork.Feed.NotificationElement
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


        val feedList = listOf<NewsAndNotification>(
            NewsElement("TITLE", "Text some text some text some text some text some text some text ", R.drawable.cat),
            NotificationElement(
                "TITLE",
                "Text some text some text some text some text some text some text ",
                R.drawable.cat
            ),
            NewsElement("TITLE", "Text some text some text some text some text some text some text ", R.drawable.cat),
            NotificationElement(
                "TITLE",
                "Text some text some text some text some text some text some text ",
                R.drawable.cat
            )
        )

        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(feedList)
        recycler.adapter = adapter

        fun onNavigationItemSelected(menu: BottomNavigationView): Boolean {
            val item = menu.selectedItemId
            when (item) {
                R.id.menu_feed -> {
                    adapter.feed = feedList.filter { it in feedList }
                    Picasso.get().load(R.drawable.himeji_castle).into(backdrop)
                }
                R.id.menu_news -> {
                    adapter.feed = feedList.filter { it is NewsElement }
                    Picasso.get().load(R.drawable.red_castle).into(backdrop)
                }
                R.id.menu_notifications -> {
                    adapter.feed = feedList.filter { it is NotificationElement }
                    Picasso.get().load(R.drawable.eu_castle).into(backdrop)
                }
            }
            return true
        }

        navigation.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(navigation)
        }

    }
}
