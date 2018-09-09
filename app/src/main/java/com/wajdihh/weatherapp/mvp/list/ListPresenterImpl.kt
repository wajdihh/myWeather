package com.wajdihh.weatherapp.mvp.list

import android.content.Context
import com.wajdihh.weatherapp.data.WeatherDataSource
import com.wajdihh.weatherapp.data.entities.Weather
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

/**
 * Created by wajdihh on 09/09/2018.
 */
class ListPresenterImpl constructor(context: Context): ListPresenter {



    private var dataSource : WeatherDataSource?=null
    private var view : ListView?=null

    init {
        dataSource = WeatherDataSource(context)
    }

    override fun attachView(v: ListView) {
        view=v
    }

    override fun loadForecasts(city: String, units: String, cnt: Int, appid: String) {

        view?.showProgress()

        dataSource?.loadForecasts(city,units,cnt,appid,object : SingleObserver<Weather>{
            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                view?.hideProgress()
                view?.onErrorLoadForecast(e)
            }

            override fun onSuccess(t: Weather) {
                view?.hideProgress()
                view?.onSuccessLoadForecast(t.list)
            }

        })
    }
}