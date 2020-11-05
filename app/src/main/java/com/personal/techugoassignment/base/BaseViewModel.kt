package com.personal.techugoassignment.base


import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.personal.techugoassignment.connectivity.retrofit.WebApiCaller
import com.personal.techugoassignment.model.ErrorResponseInfo
import com.personal.techugoassignment.utils.DialogUtils
import com.personal.techugoassignment.utils.Utility

/**
 * Description : create base view Model
 */

abstract class BaseViewModel : ViewModel() {

    private var isLoading = ObservableBoolean(false)
    var mProgressDialog: MutableLiveData<Boolean> = MutableLiveData()


    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

}
