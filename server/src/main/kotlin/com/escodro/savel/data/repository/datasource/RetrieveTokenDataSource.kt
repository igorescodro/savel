package com.escodro.savel.data.repository.datasource

import com.escodro.savel.data.repository.model.Token

interface RetrieveTokenDataSource {
    suspend fun refreshToken(): Token?
}
