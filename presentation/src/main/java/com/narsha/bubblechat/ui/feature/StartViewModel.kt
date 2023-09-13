package com.narsha.bubblechat.ui.feature

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.narsha.bubblechat.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dgsw.stac.knowledgender.remote.RetrofitBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val application: Application) : AndroidViewModel(application) {
    private var _userState = MutableStateFlow<LoginResponse?>(null)
    val userState: StateFlow<LoginResponse?> = _userState


    @Composable
    fun getGoogleClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(stringResource(id = R.string.gcp_id))
            .build()
        return GoogleSignIn.getClient(application,gso)
    }

    fun postIdToken(token: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                RetrofitBuilder.apiService.doLogin(LoginRequest(provider = "google",token = token))
            }.onSuccess { _userState.value = it }
        }
    }
}