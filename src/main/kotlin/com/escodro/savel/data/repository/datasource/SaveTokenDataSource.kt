package com.escodro.savel.data.repository.datasource

import com.escodro.savel.data.repository.model.Token

interface SaveTokenDataSource {
    suspend fun saveToken(token: Token)

    suspend fun getToken(): Token?
}
