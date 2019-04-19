package com.neobuchaemyj.sbertest.presenter.helpers


abstract class BasePresenter<T: BaseView> {

    var view: T? = null // экземпляр вьюшки в презентер

    fun bind(view: T) {
        this.view = view // функция для прикрепления вьюшки к презентеру
    }

    fun unbind() {
        this.view = null // функция для открепления, чтобы избежать утечки памяти
    }

}