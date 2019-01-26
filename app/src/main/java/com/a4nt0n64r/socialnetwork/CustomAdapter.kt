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
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.squareup.picasso.Picasso


class CustomAdapter : ListDelegationAdapter<List<NewsAndNotification>>() {

    init {
        delegatesManager.addDelegate(NewsDelegate())
        delegatesManager.addDelegate(NotificationDelegate())
    }

    fun setData(items: List<NewsAndNotification>) {
        this.items = items
        notifyDataSetChanged()
    }
}

private class NewsDelegate :
    AbsListItemAdapterDelegate<NewsElement, NewsAndNotification, NewsDelegate.ViewHolder>() {

    override fun isForViewType(item: NewsAndNotification, items: List<NewsAndNotification>, position: Int): Boolean {
        return item is NewsElement
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: NewsElement, viewHolder: ViewHolder, payloads: List<Any>) {
        Picasso.get().load(item.imgId).into(viewHolder.imagePlace)
        viewHolder.title.text = item.title
        viewHolder.text.text = item.text
        viewHolder.like.setOnClickListener {
            if (!item.isLiked){
                Picasso.get().load(R.drawable.like_icon_blue).into(viewHolder.like)
                item.isLiked = !item.isLiked
            }else{
                Picasso.get().load(R.drawable.like_icon).into(viewHolder.like)
                item.isLiked = !item.isLiked
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagePlace: ImageView = itemView.findViewById(R.id.imagePlace)
        val text:TextView = itemView.findViewById(R.id.text)
        val title:TextView = itemView.findViewById(R.id.title)
        val like:ImageView = itemView.findViewById(R.id.like)
    }
}



private class NotificationDelegate :
    AbsListItemAdapterDelegate<NotificationElement, NewsAndNotification, NotificationDelegate.ViewHolder>() {

    override fun isForViewType(item: NewsAndNotification, items: List<NewsAndNotification>, position: Int): Boolean {
        return item is NotificationElement
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.notification_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: NotificationElement, viewHolder: ViewHolder, payloads: List<Any>) {
        Picasso.get().load(item.imgId).into(viewHolder.imagePlace)
        viewHolder.title.text = item.title
        viewHolder.text.text = item.text
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagePlace: ImageView = itemView.findViewById(R.id.imagePlace)
        val text:TextView = itemView.findViewById(R.id.text)
        val title:TextView = itemView.findViewById(R.id.title)
    }
}