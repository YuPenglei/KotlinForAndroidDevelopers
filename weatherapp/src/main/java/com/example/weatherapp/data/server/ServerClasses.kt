package com.example.weatherapp.data.server

/**
 * 此处是从服务端接收到的原始数据
 * Created by yupenglei on 17/7/17.
 */
data class Coordinates(val lon: Float, val lat: Float)

data class City(val id: Long, val name: String, val coordinates: Coordinates,
                val country: String, val population: Int)

data class Temp(val day: Float, val min: Float, val max: Float, val night: Float,
                val eve: Float, val morn: Float)

data class Weather(val id: Int, val main: String, val description: String, val icon: String)

data class ForecastRaw(val dt: Long, val temp: Temp, val pressure: Float, val humidity: Int,
                       val weather: List<Weather>, val speed: Float, val deg: Int,
                       val clouds: Int, val rain: Float)

data class ForecastResult(val city: City, val code: Int, val message: Float, val cnt: Int,
                          val list: List<ForecastRaw>)
