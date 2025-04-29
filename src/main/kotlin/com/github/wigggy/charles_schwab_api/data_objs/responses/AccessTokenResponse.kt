package com.github.wigggy.charles_schwab_api.auth.responses

internal data class AccessTokenResponse(
    val expires_in: Int,
    val token_type: String,
    val scope: String,
    val refresh_token: String,
    val access_token: String,
    val id_token: String
)