package com.infinite.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.infinite.kotlin.KotlinApp
import com.infinite.kotlin.R
import com.infinite.kotlin.bean.Movie
import com.infinite.kotlin.bean.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var cal: Call<Result<MutableList<com.infinite.kotlin.bean.Movie>>> = KotlinApp.apiService()!!.getMoviesInTheater(5)
        cal.enqueue(object : Callback<Result<MutableList<Movie>>> {
            override fun onFailure(call: Call<Result<MutableList<Movie>>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Result<MutableList<Movie>>>?, response: Response<Result<MutableList<Movie>>>?) {
            }

        })
    }

}
