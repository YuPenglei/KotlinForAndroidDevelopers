package com.example.weatherapp.domain.model

/**
 * Created by yupenglei on 17/7/17.
 */

/**
 * 对应于数据库对象DayForecast
 */
data class Forecast(val id: Long, val date: Long, val description: String,
                    val high: Int, val low: Int, val iconUrl: String)

/**
 * 对应于数据库对象CityForecast
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}
