package com.personal.techugoassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.personal.techugoassignment.base.BaseViewModel
import com.personal.techugoassignment.model.CouponResponse
import com.personal.techugoassignment.model.Result
import com.personal.techugoassignment.model.ResultResponse
import com.personal.techugoassignment.model.SuccessResponse


class OfferViewModel : BaseViewModel() {

    var mTextDescription: MutableLiveData<String> = MutableLiveData()
   // var imageView: MutableLiveData<String> = MutableLiveData()
   var resultImageUrl: MutableLiveData<String> = MutableLiveData<String>()
    var mSuccessData: MutableLiveData<String> = MutableLiveData()
    private var mSuccessResponse: SuccessResponse? = null
    private var mResultResponse: ResultResponse? = null
    private var mCouponResponse: CouponResponse? = null
    var resultData = MutableLiveData<Result>()


}
