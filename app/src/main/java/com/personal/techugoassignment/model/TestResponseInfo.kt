package com.personal.techugoassignment.model

import java.io.Serializable


data class TestResponseInfo(
    val statusCode: Int,
    val APICODERESULT: String?,
    val result: Result
):Serializable

data class Result(
    val description_title:String,
    val decription_image:String,
    val description_body:String,
    val banner:List<String>,
    val latitudes:String,
    val longitude:String,
    val cupons:List<Coupon>
):Serializable

data class Coupon(
    val title: String,
    val description: String,
    val price: String
):Serializable