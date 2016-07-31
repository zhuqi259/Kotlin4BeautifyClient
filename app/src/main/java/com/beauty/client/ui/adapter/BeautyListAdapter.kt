package com.beauty.client.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beauty.client.R
import com.beauty.client.api.domain.model.User
import com.beauty.client.api.domain.model.UserList
import com.beauty.client.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_item.view.*

class BeautyListAdapter(val users: UserList, val itemClick: (User) -> Unit) : RecyclerView.Adapter<BeautyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx)
                .inflate(R.layout.user_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(users[position])
    }

    override fun getItemCount(): Int = users.size()

    class ViewHolder(view: View, val itemClick: (User) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindForecast(user: User) {
            with(user) {
                Picasso.with(itemView.ctx).load(user.photo).into(itemView.photo)
                itemView.username.text = user.username
                itemView.department.text = user.department
                itemView.telephone.text = user.telephone
                itemView.email.text = user.email
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}