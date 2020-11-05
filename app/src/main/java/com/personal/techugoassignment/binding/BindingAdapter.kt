package com.personal.techugoassignment.binding

import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import com.personal.techugoassignment.R

class BindingAdapter {
    /*
        * Description : Bind Data with xml layout
        */
    companion object {


        /**
         * Method to Bind Logo url data with image view
         */
        @BindingAdapter("CHARITY_LOGO")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            //Glide.with(view.context).load(imageUrl).error(view.context.getResources().getDrawable(R.drawable.tap)).into(view)
            //Glide.with(view.context).load(imageUrl).error(R.drawable.ic_launcher_foreground).into(view)
            //Glide.with(view.context).load(decription_image).into(view)
        }

    }
}