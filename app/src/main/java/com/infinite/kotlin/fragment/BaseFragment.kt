package com.infinite.kotlin.fragment;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infinite.kotlin.R
import com.infinite.kotlin.adapter.MovieAdapter
import com.infinite.kotlin.bean.Movie
import com.infinite.kotlin.bean.Result
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.layout_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by 19082 on 2017/6/5.
 */

abstract class BaseFragment : Fragment() {

    var mList: MutableList<Movie>? = mutableListOf()
    var mAdapter: MovieAdapter? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view :View=inflater!!.inflate(R.layout.layout_movies,container,false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager=GridLayoutManager(activity,2)
        mAdapter= MovieAdapter(activity,this,mList)
        recyclerView.adapter=mAdapter
        recyclerView.setLoadingMoreEnabled(true)
        recyclerView.setLoadingListener(object : XRecyclerView.LoadingListener{
            override fun onLoadMore() {
                getMovie(false)
            }

            override fun onRefresh() {
                getMovie(true)
            }

        })
        recyclerView.refresh()
    }

    protected var startIndex:Int=0
    protected fun getMovie(refresh:Boolean){
        startIndex=mList!!.size

        if (refresh){
            startIndex=0
        }


        getCall().enqueue(object : Callback<Result<MutableList<Movie>>> {
            override fun onFailure(call: Call<Result<MutableList<Movie>>>?, t: Throwable?) {
                Log.e("ggg",t!!.localizedMessage)
            }

            override fun onResponse(call: Call<Result<MutableList<Movie>>>?, response: Response<Result<MutableList<Movie>>>?) {
                if (refresh){
                    mList!!.clear()
                    mList!!.addAll(response!!.body()!!.subjects)
                    recyclerView.refreshComplete()

                }else{
                    mList!!.addAll(response!!.body()!!.subjects)
                    recyclerView.loadMoreComplete()
                }
                mAdapter!!.notifyDataSetChanged()
            }

        })
    }

    companion object{
        val COUNT:Int=10
    }

    abstract fun getCall():Call<Result<MutableList<Movie>>>
}
