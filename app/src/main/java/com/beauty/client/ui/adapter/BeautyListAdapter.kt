package com.beauty.client.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.beauty.client.R
import com.beauty.client.api.domain.model.User
import com.beauty.client.api.domain.model.UserList
import com.beauty.client.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

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
        private val photoView: ImageView
        private val usernameView: TextView
        private val departmentView: TextView
        private val telephoneView: TextView
        private val emailView: TextView

        init {
            photoView = view.find(R.id.photo)
            usernameView = view.find(R.id.username)
            departmentView = view.find(R.id.department)
            telephoneView = view.find(R.id.telephone)
            emailView = view.find(R.id.email)
        }

        fun bindForecast(user: User) {
            with(user) {
                Picasso.with(itemView.ctx).load(user.photo).into(photoView)
                usernameView.text = user.username
                departmentView.text = user.department
                telephoneView.text = user.telephone
                emailView.text = user.email
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}