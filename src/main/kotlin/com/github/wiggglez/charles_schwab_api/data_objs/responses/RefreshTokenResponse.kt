package com.github.wiggglez.charles_schwab_api.data_objs.responses

internal data class RefreshTokenResponse(
    val expires_in: Int,
    val token_type: String,
    val scope: String,
    val refresh_token: String,
    val access_token: String,
    val id_token: String
)
