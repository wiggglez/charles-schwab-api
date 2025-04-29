package com.github.wigggy.charles_schwab_api.data_objs.auth

data class Authorization (
    val key: String = "",
    val secret: String = "",

    val accountNumber: String = "",
    val accountNumberHashValue: String = "",

    val refresh_token: String = "",
    val access_token: String = "",
    val id_token: String = "",
    val accessTokenExpiryInMs: Long = 0,
    val refreshTokenExpiryInMs: Long = 0,
)
