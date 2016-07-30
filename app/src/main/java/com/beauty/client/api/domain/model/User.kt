package com.beauty.client.api.domain.model

import com.beauty.client.api.model.User as ModelUser

data class User(val id: String, val username: String, val photo: String)

data class UserList(val users: List<User>) {
    operator fun get(position: Int): User = users[position]
    fun size(): Int = users.size
}
