package com.a4nt0n64r.socialnetwork.Feed

import com.a4nt0n64r.socialnetwork.Feed.NewsAndNotification

data class NewsElement(
    val title: String,
    val text: String,
    val imgId:Int
) : NewsAndNotification()