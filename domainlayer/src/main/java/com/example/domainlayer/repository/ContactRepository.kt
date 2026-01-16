package com.example.domainlayer.repository

import com.example.domain.module.module.Contact
import com.example.domain.module.usecase.Result

interface ContactRepository {
    suspend fun create(name: String): Result<Contact>

    suspend fun get(id: String): Result<Contact>
    suspend fun updateName(id: String, name: String): Result<Contact>
    suspend fun updateNumber(id: String, name: String): Result<Contact>
    suspend fun delete(id: String): Result<Contact>
}