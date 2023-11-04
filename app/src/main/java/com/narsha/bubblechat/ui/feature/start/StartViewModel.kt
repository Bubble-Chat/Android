package com.narsha.bubblechat.ui.feature.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narsha.bubblechat.pref.Pref
import com.narsha.bubblechat.remote.RetrofitBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val pref: Pref) : ViewModel(){

    fun postIdToken(email: String,name: String, navigation: () -> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                Log.d("euya",email + name)
                RetrofitBuilder.apiService.doLogin(LoginRequest(email = email, name = name))
            }.onSuccess {
                pref.saveAccessToken(it.accessToken)
                navigation.invoke()
            }.onFailure {
                Log.d("throwable",it.message.toString())
//                when (it.message.toString()) {
//                    "HTTP 500" ->
//                    "HTTP 404" ->
//                    "HTTP 400" ->
//                }
            }
        }
    }
}