package com.neobuchaemyj.sbertest.api.service

import com.neobuchaemyj.sbertest.common.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class mSberClient {

    private val builder = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit by lazy {
        builder.build()
    }

    private val client: SberClient by lazy {
        retrofit.create(SberClient::class.java)
    }

    fun build() = client

}