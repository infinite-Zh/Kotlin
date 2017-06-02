package com.infinite.kotlin

import android.app.Application
import com.infinite.kotlin.net.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 19082 on 2017/6/2.
 */

class KotlinApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupRetrofit()
    }

    private fun setupRetrofit() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okhttp: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.douban.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttp)
                .build()
        mService = retrofit.create(ApiService::class.java)
    }

    companion object {
        var mService: ApiService?=null
        fun apiService(): ApiService? {
            return mService
        }
    }
}