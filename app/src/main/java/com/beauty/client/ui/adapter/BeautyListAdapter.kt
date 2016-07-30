package com.beauty.client.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.beauty.client.api.domain.model.UserList

class BeautyListAdapter(val users: UserList) : RecyclerView.Adapter<BeautyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(users[position]) {
            holder.textView.text = "$id - $username"
        }
    }

    override fun getItemCount(): Int = users.size()

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}