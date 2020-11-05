package com.personal.techugoassignment.connectivity.retrofit

import com.google.gson.GsonBuilder
import com.personal.techugoassignment.connectivity.BASE_URL
import com.personal.techugoassignment.utils.AppConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @description This class is responsible to setup client with retrofit.
 */
class ApiClient {

    companion object {
        /**
         * @param headers HashMap<String></String>, String>;
         * @param baseUrl String
         * @description Method is used to get instance of Retrofit after client setup .
         */
        fun getClient(): Retrofit {
            val builder = getBuilder()
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(getFactory())
                .build()
        }


        /**
         * @description Method is used to set the timeout time and return OkHttpClient.Builder.
         */
        private fun getBuilder(): OkHttpClient.Builder {
            return OkHttpClient().newBuilder()
                .connectTimeout(AppConstants.API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(AppConstants.API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(AppConstants.API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        }


        /**
         * @description Method is used to add the headers and generate request.
         */
        private fun generateRequestHeaders(
            chain: Interceptor.Chain,
            headers: HashMap<String, String>
        ): Request {
            val chain_builder = chain.request().newBuilder()
            for (entry in headers) {
                chain_builder.addHeader(entry.key, entry.value)
            }
            return chain_builder.build()
        }

        /**
         * @description Method is used to return theGsonConverterFactory.
         */
        private fun getFactory(): GsonConverterFactory {
            return GsonConverterFactory.create(
                GsonBuilder()
                    .setLenient()
                    .create()
            )
        }
    }
}