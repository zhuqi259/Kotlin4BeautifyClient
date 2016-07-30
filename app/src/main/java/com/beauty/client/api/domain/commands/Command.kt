package com.beauty.client.api.domain.commands

interface Command<T> {
    fun execute(): T
}