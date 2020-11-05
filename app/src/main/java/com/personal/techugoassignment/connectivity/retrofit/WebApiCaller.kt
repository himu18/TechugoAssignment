package com.personal.techugoassignment.connectivity.retrofit

import com.personal.techugoassignment.R
import com.personal.techugoassignment.application.TechugoApplication
import com.personal.techugoassignment.connectivity.ApiDataParsing
import com.personal.techugoassignment.connectivity.ApiUrl
import com.personal.techugoassignment.connectivity.network.NetworkUtil
import com.personal.techugoassignment.connectivity.network.NetworkUtil.Companion.isNetworkAvailable
import com.personal.techugoassignment.model.ErrorResponseInfo
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

/**
 * @description This class is responsible to hit the web API or to send response back to the server.
 */
class WebApiCaller {

    companion object {
        private var mWebApiCaller: WebApiCaller? = null

        /**
         * @description Method to get single instance of WebApiCaller class.
         */
        @Synchronized
        fun getInstance(): WebApiCaller {
            if (mWebApiCaller == null) {
                mWebApiCaller = WebApiCaller()
            }
            return mWebApiCaller as WebApiCaller
        }

    }

    /**
     * @param request ApiRequest
     * @description Method is used to hit singe web api at a time.
     */
    fun request(request: ApiRequest) {
        if (!isNetworkAvailable()) {
            request.onResponse.offLine()
            return
        }
        var mObservable: Observable<ResponseBody>? = null
        val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        when (request.request_type) {
            ApiUrl.GET -> mObservable = apiInterface.getDataFromServer(request.endpoint)

            else -> {
            }
        }
        mObservable?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<ResponseBody> {
                override fun onSubscribe(d: Disposable) {
                    request.onResponse.progress(
                        true,
                        TechugoApplication.instance.getString(R.string.please_wait)
                    )
                }

                override fun onNext(responseBody: ResponseBody) {
                    request.onResponse.onSuccess(
                        ApiDataParsing.getInstance().parseData(request, responseBody)!!
                    )
                }

                override fun onError(e: Throwable) {
//                    request.onResponse.onError(NetworkUtil.responseData(e)!!)
                    request.onResponse.progress(false, null.toString())
                }

                override fun onComplete() {
                    request.onResponse.progress(false, null.toString())
                }
            })
    }


    /**
     * This interface is responsible to back response of Web Api.
     */
    interface OnWebApiResponse {
        fun progress(isStart: Boolean, message: String)

        fun onSuccess(responseData: Any)

        fun onError(errorResponseInfo: ErrorResponseInfo)

        fun offLine()
    }

}