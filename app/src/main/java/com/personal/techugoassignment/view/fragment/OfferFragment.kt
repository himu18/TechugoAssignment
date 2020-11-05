package com.personal.techugoassignment.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.personal.techugoassignment.BR
import com.personal.techugoassignment.R
import com.personal.techugoassignment.viewmodel.OfferViewModel
import com.tap5050.base.BaseFragment
import kotlinx.android.synthetic.main.offer_fragment.*

class OfferFragment : BaseFragment< OfferViewModel>() {

    companion object {
        fun newInstance() = OfferFragment()
    }

    private lateinit var mOfferViewModel: OfferViewModel


    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun getlayoutId(): Int {
        return R.layout.offer_fragment
    }

    override fun getViewModel(): OfferViewModel {
        mOfferViewModel = ViewModelProviders.of(this).get(OfferViewModel::class.java)
        return mOfferViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mOfferViewModel.callDataApi()


        setObserver()
    }

    private fun setObserver() {
        mOfferViewModel.resultData.observe(viewLifecycleOwner, Observer {result->
            Glide.with(this).load(result.decription_image).into(image)
            //text_description.text = result.description_body
        })

    }
}
