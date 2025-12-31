package com.example.datalayer.di

import com.example.domain.module.repository.AccountRepository
import com.example.domain.module.usecase.AccountUseCase
import com.example.domainlayer.repository.ContactRepository
import com.example.domainlayer.repository.ExpenseRecordRepository
import com.example.domainlayer.usecase.ContactUseCase
import com.example.domainlayer.usecase.ExpenseRecordUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideAccountUseCase(repository: AccountRepository): AccountUseCase {
        return AccountUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideContactUseCase(repository: ContactRepository): ContactUseCase {
        return ContactUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideExpenseRecordRepository(repository: ExpenseRecordRepository): ExpenseRecordUseCase {
        return ExpenseRecordUseCase(repository)
    }
}
