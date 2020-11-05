package com.personal.techugoassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SuccessResponse(
    @SerializedName("statusCode")
    @Expose
    var statusCode: Int? = null,

    @SerializedName("APICODERESULT")
    @Expose
    var APICODERESULT: String? = null,

    @SerializedName("result")
    @Expose
    val result: ResultResponse? = null
)