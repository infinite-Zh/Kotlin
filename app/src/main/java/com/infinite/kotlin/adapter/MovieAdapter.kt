package com.infinite.kotlin.adapter

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.infinite.kotlin.R
import com.infinite.kotlin.bean.Movie
/**
 * Created by 19082 on 2017/6/5.
 */
class MovieAdapter(fragment: Fragment,list: MutableList<Movie>?) : Adapter<MovieAdapter.MovieViewHolder>() {

    var fragment: Fragment? = null
    var mList: MutableList<Movie>? = null

    init {
        this.fragment=fragment
        this.mList=list
    }
    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): MovieViewHolder {
        val itemView: View = LayoutInflater.from(p0!!.context).inflate(R.layout.item_movie, p0, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: MovieViewHolder?, p1: Int) {
        val movie: Movie = mList!![p1]
        p0!!.title!!.text=movie.title
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    class MovieViewHolder(itemView: View?) : ViewHolder(itemView) {
        var title:TextView? = null

        init {
            title=itemView!!.findViewById(R.id.text_title) as TextView
        }
    }
}