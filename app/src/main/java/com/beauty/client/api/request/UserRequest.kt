package com.beauty.client.api.request

import com.beauty.client.api.model.UserResult
import com.google.gson.Gson
import java.net.URL

class UserRequest(val page_number: Int, val page_size: Int) {
    companion object {
        private val url = "http://192.168.1.107:5000/api/v1.0/users/pages"
    }

    fun execute(): UserResult {
        val usersJsonStr: String = URL("$url?page_number=$page_number&page_size=$page_size").readText()
        return Gson().fromJson(usersJsonStr, UserResult::class.java)
    }
}