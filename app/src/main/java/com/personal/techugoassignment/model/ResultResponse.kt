package com.personal.techugoassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("description_title")
    @Expose
     var descriptionTitle: String? = null,

    @SerializedName("decription_image")
    @Expose
     val decriptionImage: String? = null,

    @SerializedName("description_body")
    @Expose
     val descriptionBody: String? = null,

    @SerializedName("banner")
    @Expose
     val banner: List<String>? = null,

    @SerializedName("latitudes")
    @Expose
     val latitudes: String? = null,

    @SerializedName("longitude")
    @Expose
     val longitude: String? = null,

    @SerializedName("cupons")
    @Expose
     var cupons: List<CouponResponse ?>? = null
)