package com.personal.techugoassignment.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.personal.techugoassignment.BR
import com.personal.techugoassignment.R
import com.personal.techugoassignment.viewmodel.OfferDetailsViewModel
import com.tap5050.base.BaseFragment

/**
 * A placeholder fragment containing a simple view.
 */
class OfferDetailsFragment : BaseFragment<OfferDetailsViewModel>() {

    private lateinit var mOfferDetailsViewModel: OfferDetailsViewModel
    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun getlayoutId(): Int {
        return R.layout.fragment_offer_details
    }

    override fun getViewModel(): OfferDetailsViewModel {
        mOfferDetailsViewModel = ViewModelProviders.of(this).get(OfferDetailsViewModel::class.java)
        return mOfferDetailsViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}