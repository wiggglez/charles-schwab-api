package com.github.wiggglez.charles_schwab_api.data_objs.auth

interface TokenHandler {

    fun saveTokens(authTokens: Authorization)

    fun getTokens(): Authorization?


}