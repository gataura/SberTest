package com.neobuchaemyj.sbertest.api.service

import retrofit2.Call
import com.neobuchaemyj.sbertest.api.model.SberUnit
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers

interface SberClient {

    @GET("bins/dxcz4")
    fun getSberUnits(): Call<List<SberUnit>>

}