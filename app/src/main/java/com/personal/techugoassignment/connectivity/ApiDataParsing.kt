package com.personal.techugoassignment.connectivity

import com.google.gson.Gson
import com.personal.techugoassignment.connectivity.network.NetworkUtil
import com.personal.techugoassignment.connectivity.retrofit.ApiRequest
import com.personal.techugoassignment.model.TestResponseInfo
import okhttp3.ResponseBody


class ApiDataParsing {

    companion object {
        private var mApiDataParsing: ApiDataParsing? = null

        /**
         * @description Method to get single instance of WebApiCaller class.
         */
        @Synchronized
        fun getInstance(): ApiDataParsing {
            if (mApiDataParsing == null) {
                mApiDataParsing = ApiDataParsing()
            }
            return mApiDataParsing as ApiDataParsing
        }
    }

    /**
     * @param request ApiRequest;
     * @param body    ResponseBody;
     * @description Method is used to parse the data.
     */
    fun parseData(request: ApiRequest, body: ResponseBody): Any? {
        try {
            val response = body.string()
            when (request.purpose) {
                TEST_DATA -> {
                    return getObject(response, TestResponseInfo::class.java);
                }
                else -> return response
            }
        } catch (e: Exception) {
            request.onResponse.onError(NetworkUtil.responseData(e)!!)
            return e.toString()
        }
    }

    /**
     * @description Method is used to convert json data into respective POJO class.
     */
    private fun <T> getObject(response: String, instance: Class<T>): Any? {
        return Gson().fromJson(response, instance)
    }
}