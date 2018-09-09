package com.wajdihh.weatherapp.mvp.list

import com.wajdihh.weatherapp.data.entities.Forecast

/**
 * Created by wajdihh on 09/09/2018.
 */
interface ListView {

    /**
     * Show progress when treat operation
     */
    fun showProgress()
    /**
     * Hide progress after treatment
     */
    fun hideProgress()

    /**
     * when login normal is with success
     */
    fun onSuccessLoadForecast(list: List<Forecast>)

    /**
     * when login normal is with Error
     */
    fun onErrorLoadForecast(throwable: Throwable)

}