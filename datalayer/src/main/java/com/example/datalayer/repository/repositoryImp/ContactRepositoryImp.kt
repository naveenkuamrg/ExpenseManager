package com.example.datalayer.repository.repositoryImp

import com.example.domain.module.module.Contact
import com.example.domain.module.usecase.Result
import com.example.domainlayer.repository.ContactRepository

class ContactRepositoryImp: ContactRepository {
    override suspend fun create(name: String): Result<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: String): Result<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun updateName(
        id: String,
        name: String
    ): Result<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun updateNumber(
        id: String,
        name: String
    ): Result<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Result<Contact> {
        TODO("Not yet implemented")
    }
}