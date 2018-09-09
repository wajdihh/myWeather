package com.wajdihh.weatherapp.mvp.list

/**
 * Created by wajdihh on 09/09/2018.
 */
interface ListPresenter {

    fun attachView(v: ListView)

    fun loadForecasts(city:String,units:String,cnt:Int,appid:String)
}