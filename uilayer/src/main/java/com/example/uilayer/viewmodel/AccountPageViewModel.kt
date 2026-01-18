package com.example.uilayer.viewmodel


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.module.module.Account
import com.example.domain.module.usecase.AccountUseCase
import com.example.domain.module.usecase.AccountUseCaseParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountPageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val accountUseCase: AccountUseCase
) : ViewModel() {


    val accountId: String? = savedStateHandle["id"]


    private val _accountState =
        MutableStateFlow<com.example.domain.module.usecase.Result<Account>?>(null)
    val accountState: StateFlow<com.example.domain.module.usecase.Result<Account>?> = _accountState

    fun getAccount(id: String) {
        viewModelScope.launch {
            val result = accountUseCase.execute(
                AccountUseCaseParams(AccountUseCaseParams.GET_RECORD, id)
            )
            _accountState.emit(result)
        }
    }

    fun createAccount(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
             accountUseCase.execute(
                AccountUseCaseParams(
                    AccountUseCaseParams.CREATE_RECORD,
                    name = name
                )
            )
        }
    }
}
