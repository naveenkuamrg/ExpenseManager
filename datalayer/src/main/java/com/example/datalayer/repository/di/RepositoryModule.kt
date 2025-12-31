package com.example.datalayer.di

import com.example.datalayer.repository.repositoryImp.AccountRepositoryImp
import com.example.datalayer.repository.repositoryImp.ContactRepositoryImp
import com.example.datalayer.repository.repositoryImp.ExpenseRecordRepositoryImp
import com.example.domain.module.repository.AccountRepository
import com.example.domainlayer.repository.ContactRepository
import com.example.domainlayer.repository.ExpenseRecordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAccountRepository(
        impl: AccountRepositoryImp
    ): AccountRepository

    @Binds
    abstract fun bindContactRepository(
        impl: ContactRepositoryImp
    ): ContactRepository

    @Binds
    abstract fun bindExpenseRecordRepository(
        impl: ExpenseRecordRepositoryImp
    ): ExpenseRecordRepository
}