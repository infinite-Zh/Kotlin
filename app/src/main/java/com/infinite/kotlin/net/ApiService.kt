package com.infinite.kotlin.net

import com.infinite.kotlin.bean.Movie
import com.infinite.kotlin.bean.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 19082 on 2017/6/2.
 */
interface ApiService{

    @GET("v2/movie/in_theaters")
    fun getMoviesInTheater(@Query ("count") count : Int,@Query("start") startIndex:Int): Call<Result<MutableList<Movie>>>

    @GET("v2/movie/coming_soon")
    fun getMoviesComingSoon(@Query ("count") count : Int, @Query("start") startIndex:Int): Call<Result<MutableList<Movie>>>
}