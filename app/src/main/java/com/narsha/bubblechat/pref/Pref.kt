package com.narsha.bubblechat.pref

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow


val ACCESSTOKEN_KEY = stringPreferencesKey("accessToken")
val REFRESHTOKEN_KEY = stringPreferencesKey("refreshToken")


interface Pref {
    fun getAccessToken(): Flow<String>
    fun getRefreshToken(): Flow<String>




    suspend fun saveAccessToken(accessToken: String)

    suspend fun saveRefreshToken( refreshToken: String)

}