package com.narsha.bubblechat.ui.feature.start

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import dgsw.proj.bubblechat.R
import dgsw.stac.knowledgender.remote.RetrofitBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val application: Application) :
    AndroidViewModel(application) {
    private var _userState = MutableStateFlow<LoginResponse?>(null)
    val userState: StateFlow<LoginResponse?> = _userState




    fun postIdToken(email: String,name: String, navigation: () -> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                Log.d("euya",email + name)
                RetrofitBuilder.apiService.doLogin(LoginRequest(email = email, name = name))
            }.onSuccess {
                _userState.value = it
                navigation.invoke()
            }
        }
    }
}