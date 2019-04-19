package com.neobuchaemyj.sbertest.presenter.helpers

import com.neobuchaemyj.sbertest.api.model.SberUnit

interface SberView: BaseView {

    fun load()
    fun onLoad(response: List<SberUnit>)
    fun onError(t: Throwable?)

}