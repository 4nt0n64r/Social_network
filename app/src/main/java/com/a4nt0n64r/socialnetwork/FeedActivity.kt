package com.a4nt0n64r.socialnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        recycler.layoutManager = LinearLayoutManager(this)

        val feedList = listOf<NewsAndNotification>(
            NewsElement(
                getString(R.string.season_changing),
                getString(R.string.season_changing_text),
                R.drawable.gravura,
                false
            ),
            NotificationElement(
                getString(R.string.insurrection),
                getString(R.string.vassal_betrayal),
                R.drawable.betray
            ),
            NotificationElement(
                getString(R.string.hojou),
                getString(R.string.union),
                R.drawable.union
            ),
            NotificationElement(
                getString(R.string.war),
                getString(R.string.takeda) + " " + getString(R.string.invade),
                R.drawable.war
            ),
            NewsElement(
                getString(R.string.battle_title),
                getString(R.string.battle_description),
                R.drawable.kavankajima,
                false
            )
            ,
            NotificationElement(
                getString(R.string.mesage_title),
                getString(R.string.message),
                R.drawable.takeda
            ),
            NewsElement(
                getString(R.string.battle_title),
                getString(R.string.battle_description),
                R.drawable.kavankajima,
                false
            )
        )

        val adapter = CustomAdapter()
        adapter.setData(feedList)
        recycler.adapter = adapter

//        Почему если использовать этот случай то срабатывает только после 2 го нажатия?
//        fun onNavigationItemSelected(menu: BottomNavigationView, adapter: CustomAdapter): Boolean {
//            val item = menu.selectedItemId
//            when (item) {
//                R.id.menu_feed -> {
//                    adapter.setData(feedList.filter { it in feedList })
//                    Picasso.get().load(R.drawable.himeji_castle).into(backdrop)
//                }
//                R.id.menu_news -> {
//                    adapter.setData(feedList.filter { it is NewsElement })
//                    Picasso.get().load(R.drawable.japan_castle1).into(backdrop)
//                }
//                R.id.menu_notifications -> {
//                    adapter.setData(feedList.filter { it is NotificationElement })
//                    Picasso.get().load(R.drawable.japan_castle2).into(backdrop)
//                }
//            }
//            return true
//        }
//
//
//        navigation.setOnNavigationItemSelectedListener {
//            onNavigationItemSelected(navigation, adapter)
//
//        }


        val listener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_feed -> {
                    adapter.setData(feedList.filter { it in feedList })
                    Picasso.get().load(R.drawable.himeji_castle).into(backdrop)
                }
                R.id.menu_news -> {
                    adapter.setData(feedList.filter { it is NewsElement })
                    Picasso.get().load(R.drawable.japan_castle1).into(backdrop)
                }
                R.id.menu_notifications -> {
                    adapter.setData(feedList.filter { it is NotificationElement })
                    Picasso.get().load(R.drawable.japan_castle2).into(backdrop)
                }
            }
            true

        }

        navigation.setOnNavigationItemSelectedListener(listener)
    }


}
