package com.personal.techugoassignment.connectivity.retrofit

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * @description It contains WebApi methods.
 */
interface ApiInterface {

    /**
     * @param endPoint String
     * @return return ResponseBody
     * @description Call GET type's web API
     */
    @GET
    fun getDataFromServer(@Url endPoint: String): Observable<ResponseBody>

    /**
     * @param endPoint String
     * @param hashMap  HashMap<String,Object>
     * @return return response
     * @description Call POST type's web API
     */
    @POST
    fun postDataOnServer(@Url endPoint: String, @Body request: Any): Observable<ResponseBody>


    /**
     * @param endPoint String
     * @param hashMap  HashMap<String,Object>
     * @return return response
     * @description Call PUT type's web API
     */
    @PUT
    fun putDataOnServer(@Url endPoint: String, @Body request: Any): Observable<ResponseBody>

}
