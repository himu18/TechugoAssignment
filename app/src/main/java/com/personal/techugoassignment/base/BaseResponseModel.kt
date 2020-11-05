package com.tap5050.base


/**
 * Description :created base response model
 */

data class BaseResponseModel<T>(
    val Code: Int,
    val Data: T,
    val Message: String,
    val Status: String
)

