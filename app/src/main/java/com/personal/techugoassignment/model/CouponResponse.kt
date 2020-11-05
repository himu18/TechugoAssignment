package com.personal.techugoassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CouponResponse(
    @SerializedName("title") @Expose
     var title: String? = null,
    @SerializedName("description")
    @Expose
     val description: String? = null,
    @SerializedName("price")
    @Expose
     val price: String? = null

)