package com.example.weatherapp.extensions

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Created by yupenglei on 17/7/20.
 */

/**
 * parser是一个将map转为需求对象的lambda
 * 调用parseList函数，传入一个自定义的MapRowParser，对其columns调用lambda
 */
fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T {
                return parser(columns)
            }
        })

/**
 * parser是一个将map转为需求对象的lambda
 * 调用parseOpt函数，传入一个自定义的MapRowParser，对其columns调用lambda
 */
fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
        parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete from $tableName")
}

/**
 * 由于按Id查询比较常见，所以抽取出扩展函数
 */
fun SelectQueryBuilder.byId(id: Long): SelectQueryBuilder = whereSimple("_id=?", id.toString())
