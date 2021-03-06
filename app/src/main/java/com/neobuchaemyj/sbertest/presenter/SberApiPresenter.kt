package com.neobuchaemyj.sbertest.presenter

import com.neobuchaemyj.sbertest.api.model.SberUnit
import com.neobuchaemyj.sbertest.api.service.mSberClient
import com.neobuchaemyj.sbertest.presenter.helpers.BasePresenter
import com.neobuchaemyj.sbertest.presenter.helpers.SberView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

/** Основной перезентер */

class SberApiPresenter: BasePresenter<SberView>(), ISberPresenter {


    val client = mSberClient().build()
    var listUnits = mutableListOf<SberUnit>()



    private fun getListOfUnits() = client.getSberUnits() // функция вызова retrofit запроса

    override fun load() {
        listUnits.clear()
        getListOfUnits().enqueue(object: Callback<List<SberUnit>> {
            override fun onResponse(call: Call<List<SberUnit>>, response: Response<List<SberUnit>>) {
                if (response.body() != null) {
                    view?.onLoad(response.body()!!) // в случае успеха вызываем соответсвующую функцию во вьюшке и передаем список с объектами для размещения на карте
                }
            }

            override fun onFailure(call: Call<List<SberUnit>>, t: Throwable) {
                view?.onError(t) // в случае ошибки выводим Toast с ошибкой
            }
        })
    }




}