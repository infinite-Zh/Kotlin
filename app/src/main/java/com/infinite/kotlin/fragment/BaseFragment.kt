package com.infinite.kotlin.fragment;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infinite.kotlin.KotlinApp
import com.infinite.kotlin.R
import com.infinite.kotlin.adapter.MovieAdapter
import com.infinite.kotlin.bean.Movie
import com.infinite.kotlin.bean.Result
import kotlinx.android.synthetic.main.layout_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by 19082 on 2017/6/5.
 */

open class BaseFragment : Fragment() {

    var mList: MutableList<Movie>? = mutableListOf()
    var mAdapter: MovieAdapter? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view :View=inflater!!.inflate(R.layout.layout_movies,container,false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager=GridLayoutManager(activity,2)
        mAdapter= MovieAdapter(this,mList)
        recyclerView.adapter=mAdapter
        getMovie()
    }

    protected fun getMovie(){
        var cal: Call<Result<MutableList<Movie>>> = KotlinApp.apiService()!!.getMoviesInTheater(5)
        cal.enqueue(object : Callback<Result<MutableList<Movie>>> {
            override fun onFailure(call: Call<Result<MutableList<Movie>>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Result<MutableList<Movie>>>?, response: Response<Result<MutableList<Movie>>>?) {
                mList!!.addAll(response!!.body()!!.subjects)
                mAdapter!!.notifyDataSetChanged()
            }

        })
    }
}
