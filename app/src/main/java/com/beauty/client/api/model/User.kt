package com.beauty.client.api.model

data class User(val id: String,
                val username: String,
                val gender: Int,
                val department: String,
                val major: String,
                val teacher: String,
                val telephone: String,
                val email: String,
                val uri: String,
                val photo: String)

data class UserResult(val users: List<User>)
