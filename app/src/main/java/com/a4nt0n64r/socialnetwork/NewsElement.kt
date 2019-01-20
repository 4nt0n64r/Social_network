package com.a4nt0n64r.socialnetwork

data class NewsElement(
    override val title: String,
    override val text: String
) : NewsAndNotification()