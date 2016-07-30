package com.beauty.client.api.domain.commands

import com.beauty.client.api.domain.mappers.UserDataMapper
import com.beauty.client.api.domain.model.UserList
import com.beauty.client.api.request.UserRequest

class RequestUserCommand(val page_number: Int = 1, val page_size: Int = 5) : Command<UserList> {
    override fun execute(): UserList {
        val userRequest = UserRequest(page_number, page_size)
        return UserDataMapper().convertFromDataModel(userRequest.execute())
    }
}