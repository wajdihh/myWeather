package com.wajdihh.weatherapp.data.remote

import com.wajdihh.weatherapp.data.entities.Weather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by wajdihh on 09/09/2018.
 */
interface WeatherApi {


    /**
     * Retourner toutes les weather
     * TODO : we can use single , observable or completable read more
     */

    @GET("/data/2.5/forecast/daily")
    fun getWeather(@Query("q") city:String,
                   @Query("units") units:String,
                   @Query("cnt") cnt:Int,
                   @Query("appid") appid:String): Single<Weather>
}