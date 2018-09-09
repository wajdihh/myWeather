package com.wajdihh.weatherapp.data.entities

/**
 * Created by wajdihh on 09/09/2018.
 */
data class Forecast(
        var dt : Int,
        var pressure : Float,
        var humidity : Int,
        var speed : Float,
        var deg : Int,
        var clouds : Int,
        var temp : Temp

)