package com.neobuchaemyj.sbertest.presenter.helpers

import com.neobuchaemyj.sbertest.api.model.SberUnit

interface SberView: BaseView {

    fun load() // функция для вызова функции презентера для загрузки объектов с сервера
    fun onLoad(response: List<SberUnit>) // функция вызываемая после загрузки данных сервера
    fun onError(t: Throwable?) // функция в случае неудачной загрузки данных

}