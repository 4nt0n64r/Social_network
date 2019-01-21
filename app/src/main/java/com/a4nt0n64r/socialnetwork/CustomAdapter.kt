package com.a4nt0n64r.socialnetwork


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a4nt0n64r.socialnetwork.Feed.NewsAndNotification
import com.a4nt0n64r.socialnetwork.Feed.NewsElement
import com.a4nt0n64r.socialnetwork.Feed.NotificationElement
import com.squareup.picasso.Picasso

class CustomAdapter(feed: List<NewsAndNotification>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var feed = feed
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            0 -> return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.news_layout,
                    parent,
                    false
                )
            )

            1 -> return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.notification_layout,
                    parent,
                    false

                )
            )
            else -> return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.news_layout,
                    parent,
                    false
                )
            )
        }
    }


    override fun getItemViewType(position: Int): Int {
        when (feed[position]) {
            is NewsElement -> return 0
            is NotificationElement -> return 1
            else -> return 0
        }
    }

    override fun getItemCount(): Int {
        return feed.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: NewsAndNotification = feed[position]
        when (item) {
            is NewsElement -> {
                holder.title.text = item.title
                holder.text.text = item.text
                Picasso.get().load(item.imgId).into(holder.imagePlace)
            }
            is NotificationElement -> {
                holder.title.text = item.title
                holder.text.text = item.text
                Picasso.get().load(item.imgId).into(holder.imagePlace)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById(R.id.title) as TextView
        val text = itemView.findViewById(R.id.text) as TextView
        val imagePlace = itemView.findViewById(R.id.imagePlace) as ImageView
    }

}