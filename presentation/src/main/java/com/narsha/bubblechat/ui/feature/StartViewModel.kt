package com.narsha.bubblechat.ui.feature

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private var userState = MutableLiveData<GoogleUserModel>()
    val googleUser: LiveData<GoogleUserModel> = userState


    fun fetchSignInUser(email: String?, name: String?) {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .
    }


}