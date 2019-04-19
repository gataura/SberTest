package com.neobuchaemyj.sbertest.api.service

import retrofit2.Call
import com.neobuchaemyj.sbertest.api.model.SberUnit
import retrofit2.http.GET

/** Retrofit запрос на локальный сервлет Tomcat для получения Json объекта*/

interface SberClient {

    @GET("sberTask/")
    fun getSberUnits(): Call<List<SberUnit>>

}