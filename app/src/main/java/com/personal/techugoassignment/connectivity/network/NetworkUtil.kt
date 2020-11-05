package com.personal.techugoassignment.connectivity.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.google.gson.Gson
import com.personal.techugoassignment.application.TechugoApplication
import com.personal.techugoassignment.model.ErrorResponseInfo
import retrofit2.HttpException


/**
 * @description This class is responsible for network utilities function.
 */
class NetworkUtil {



    companion object {
        /**
         * @return boolean
         * @description This method is used to check internet connection.
         */
        fun isNetworkAvailable(): Boolean {
            var activeNetwork: NetworkInfo? = null
            val cm =
                TechugoApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            activeNetwork = cm.activeNetworkInfo
            return null != activeNetwork && activeNetwork.isConnected
        }

        /**
         * Create API path end URL
         */
        fun endURL(login: String): String {
            val apiPath = login
            return apiPath
        }


/*
        *//**
         * Create API path end URL
         *//*
        fun endURL(login: String): String {
            val apiPath =
                login + TechugoApplication.instance.getString(R.string.path_separator) + getSerial() + Tap5050Application.instance.getString(
                    R.string.path_separator
                ) + getCurrentTimeStamp()
            return apiPath + Tap5050Application.instance.getString(R.string.path_separator) + signature
        }*/




        /**
         * Handle different types of error response data from API
         */
        fun responseData(throwable: Throwable): ErrorResponseInfo? {
            if (throwable is HttpException) {
                val s = throwable.response()!!.errorBody()!!.string()
                return when (throwable.code()) {
                    //handle code 400 and 403
                    400, 403 -> getErrorData(s)
                    else -> null
                }
            }
            return null
        }


        /**
         * Get error code from API
         */
        private fun getErrorData(response: String?): ErrorResponseInfo? {
            val replace = response?.replace("\n", "")
            return Gson().fromJson(replace, ErrorResponseInfo::class.java)
        }
    }

}