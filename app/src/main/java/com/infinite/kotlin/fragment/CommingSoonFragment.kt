package com.infinite.kotlin.fragment;

import com.infinite.kotlin.KotlinApp
import com.infinite.kotlin.bean.Movie;
import com.infinite.kotlin.bean.Result
import retrofit2.Call

/**
 * Created by 19082 on 2017/6/6.
 */

class CommingSoonFragment : BaseFragment() {
    override fun getCall(): Call<Result<MutableList<Movie>>> {
        return KotlinApp.apiService()!!.getMoviesCommingSoon(COUNT,startIndex)
    }


}
