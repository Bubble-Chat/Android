package com.narsha.bubblechat.pref

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class PrefImpl(private val dataStore: DataStore<Preferences>): Pref {
    override fun getAccessToken(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[ACCESSTOKEN_KEY] ?: ""
        }
    }

    override fun getRefreshToken(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[REFRESHTOKEN_KEY] ?: ""
        }
    }




    override suspend fun saveRefreshToken(refreshToken: String) {
        dataStore.edit {
            it[REFRESHTOKEN_KEY] = refreshToken
        }
    }


    override suspend fun saveAccessToken(accessToken: String) {
        dataStore.edit {
            it[ACCESSTOKEN_KEY] = accessToken
        }
    }



}