package com.beauty.client.api.domain.mappers

import com.beauty.client.api.domain.model.User
import com.beauty.client.api.domain.model.UserList
import com.beauty.client.api.model.UserResult
import com.beauty.client.api.model.User as ModelUser

class UserDataMapper {
    fun convertFromDataModel(user: UserResult): UserList {
        return UserList(convertUserListToDomain(user.users))
    }

    private fun convertUserListToDomain(users: List<ModelUser>):
            List<User> {
        return users.map { convertUserItemListToDomain(it) }
    }

    private fun convertUserItemListToDomain(user: ModelUser): User {
        return User(user.id, user.username,
                user.department, user.telephone,
                user.email, user.uri, user.photo)
    }
}
