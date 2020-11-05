package com.personal.techugoassignment.model


/**
 * To store all error type API response  data
 */
data class ErrorResponseInfo(
    val code: Int,
    val message: String
) {
    override fun toString(): String {
        return ""
        //Tap5050Application.mContext!!.getString(R.string.code) + code + "\n"+context.getString(R.string.message) + message
    }
}