package com.narsha.bubblechat.google

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SignInGoogleViewModel(application: Application) : AndroidViewModel(application) {
    private var userState = MutableLiveData<GoogleUserModel>()
    val googleUser: LiveData<GoogleUserModel> = userState

    private var loadingState = MutableLiveData(false)
    val loading: LiveData<Boolean> = loadingState

    fun fetchSignInUser(email: String?, name: String?) {
        loadingState.value = true

        viewModelScope.launch {
            userState.value = GoogleUserModel(
                email = email,
                name = name,
            )
        }

        loadingState.value = false
    }

    fun hideLoading() {
        loadingState.value = false
    }

    fun showLoading() {
        loadingState.value = true
    }


}