package com.ayush.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class newsadapter(private val listner:Newsitemclicked): RecyclerView.Adapter<newsviewholder>() {
    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsviewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder=newsviewholder(view)
        view.setOnClickListener{
             listner.onitemclick(items[viewHolder.adapterPosition])

        }
        return viewHolder

    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: newsviewholder, position: Int) {
        val currentitems=items[position]

        holder.titleview.text=currentitems.title
    }
    fun updatenews(updatenews:ArrayList<News>){
        items.clear()
        items.addAll(updatenews)

        notifyDataSetChanged()
    }

}

class newsviewholder(itemView:View):RecyclerView.ViewHolder(itemView){
    val titleview:  TextView=itemView.findViewById(R.id.title)

}
interface Newsitemclicked{
    fun onitemclick(item:News)
}