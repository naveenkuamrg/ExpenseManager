package com.example.domainlayer.usecase

import com.example.domain.module.module.Contact
import com.example.domain.module.usecase.BaseUseCase
import com.example.domain.module.usecase.Result
import com.example.domainlayer.repository.ContactRepository
import javax.inject.Inject

class ContactUseCase @Inject constructor(private val repository: ContactRepository) :
    BaseUseCase<Contact, ContactUseCaseParams>() {
    override suspend fun executeBackground(params: ContactUseCaseParams): Result<Contact> {
        return when (params.requestType) {
            ContactUseCaseParams.GET_CONTACT -> {
                params.id ?: return Result.Failure("ID required", 400)
                repository.get(params.id )
            }

            ContactUseCaseParams.UPDATE_CONTACT_NAME -> {
                params.id ?: return Result.Failure("ID required", 400)
                params.name ?: return Result.Failure("Name Required", 400)
                repository.updateName(params.id ,  params.name)
            }

            ContactUseCaseParams.DELETE_CONTACT -> {
                params.id ?: return Result.Failure("ID required", 400)
                repository.delete(params.id )
            }

            ContactUseCaseParams.CREATE_CONTACT -> {
               params.name ?: return Result.Failure("ID Required", 400)
                repository.create( params.name)
            }

            ContactUseCaseParams.UPDATE_CONTACT_NO -> {
                repository.updateNumber(params.id!!, params.number!!)
            }

            else -> {
                Result.Failure(error = "not supported operation", 505)
            }
        }
    }
}


data class ContactUseCaseParams(
    val id: String? = null,
    val name: String? = null,
    val number: String? = null,
    val requestType: Int
) {
    companion object {
        const val GET_CONTACT = 1
        const val GET_ALL_CONTACT = 2
        const val UPDATE_CONTACT_NAME = 3
        const val DELETE_CONTACT = 5
        const val CREATE_CONTACT = 6
        const val UPDATE_CONTACT_NO = 7
    }
}