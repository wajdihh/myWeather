package com.wajdihh.weatherapp.data

import android.content.Context
import com.wajdihh.weatherapp.data.entities.Weather
import com.wajdihh.weatherapp.data.remote.Retrofit2Client
import com.wajdihh.weatherapp.data.remote.WeatherApi
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by wajdihh on 09/09/2018.
 */
class WeatherDataSource constructor(context: Context) {


    var weatherApi : WeatherApi?=null
    init {
        weatherApi= Retrofit2Client.getClient(context)?.create(WeatherApi::class.java)

    }

    fun loadForecasts(city:String,units:String,cnt:Int,appid:String,observer : SingleObserver<Weather>)  {

        var weatherObs = weatherApi?.getWeather(city,units,cnt,appid)!!

        weatherObs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    }
}