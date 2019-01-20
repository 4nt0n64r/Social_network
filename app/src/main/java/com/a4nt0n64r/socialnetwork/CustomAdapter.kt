package com.a4nt0n64r.socialnetwork

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val langList: List<NewsAndNotification>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lang_items_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return langList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lang: ProgrammingLanguage = langList[position]

        holder.name.text = lang.name
        holder.authors.text = lang.authors
        holder.year.text = lang.year.toString()
        holder.paradigms.text = lang.paradigms.toString()
        holder.logo.setImageBitmap(lang.logo)
        holder.indexTIOBE.text = lang.indexTIOBE.toString()
        holder.constr.setOnClickListener {
            val intent = Intent(holder.card.context,WebActivity::class.java)
            intent.putExtra("LINK",lang.link)
            val context: Context = holder.card.context
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.name) as TextView
        val authors = itemView.findViewById(R.id.authors) as TextView
        val year = itemView.findViewById(R.id.year) as TextView
        val paradigms = itemView.findViewById(R.id.paradigms) as TextView
        val logo = itemView.findViewById(R.id.logo) as ImageView
        val indexTIOBE = itemView.findViewById(R.id.indexTIOBE) as TextView
        val card = itemView.findViewById(R.id.cardView) as CardView
        val constr = itemView.findViewById(R.id.constr) as ConstraintLayout
    }

}