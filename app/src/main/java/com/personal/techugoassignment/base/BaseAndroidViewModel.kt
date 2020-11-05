package com.tap5050.base


import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.personal.techugoassignment.connectivity.retrofit.WebApiCaller
import com.personal.techugoassignment.model.ErrorResponseInfo
import com.personal.techugoassignment.utils.DialogUtils
import com.personal.techugoassignment.utils.Utility

/**
 * Description : create base view Model
 */

abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private var isLoading = ObservableBoolean(false)

    var mProgressDialog: MutableLiveData<Boolean> = MutableLiveData()

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

}
