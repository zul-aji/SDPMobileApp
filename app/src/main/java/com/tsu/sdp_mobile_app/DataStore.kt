package com.tsu.sdp_mobile_app

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

const val DATA_STORE_NAME = "MovieCatalogueDataStore"
val TOKEN_PREF_KEY = stringPreferencesKey("token")


private val Context.datastore: androidx.datastore.core.DataStore<Preferences> by preferencesDataStore(
    name = DATA_STORE_NAME
)

suspend fun Context.savePrefToken(token: String) {
    datastore.edit {
        it[TOKEN_PREF_KEY] = token
    }
}

suspend fun Context.getPrefToken(): String? = datastore.data
    .map {
        it[TOKEN_PREF_KEY]
    }.first()

suspend fun Context.deletePrefToken() {
    datastore.edit {
        it.remove(TOKEN_PREF_KEY)
    }
}