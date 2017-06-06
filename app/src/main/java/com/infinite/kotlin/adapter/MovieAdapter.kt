package com.infinite.kotlin.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.infinite.kotlin.R
import com.infinite.kotlin.bean.Movie
import com.infinite.kotlin.tools.SystemUtils

/**
 * Created by 19082 on 2017/6/5.
 */
class MovieAdapter(context:Context,fragment: Fragment,list: MutableList<Movie>?) : Adapter<MovieAdapter.MovieViewHolder>() {

    var fragment: Fragment? = null
    var mList: MutableList<Movie>? = null
    var context:Context

    var imageWidth:Int = 0
    var imageHeight:Int=0

    init {
        this.fragment=fragment
        this.mList=list
        this.context=context
        val screenWidth=SystemUtils.getScreenWidth(context)
        imageWidth=screenWidth*2/5
        imageHeight=imageWidth*12/9
    }
    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): MovieViewHolder {
        val itemView: View = LayoutInflater.from(p0!!.context).inflate(R.layout.item_movie, p0, false)
        return MovieViewHolder(itemView,imageWidth,imageHeight)
    }

    override fun onBindViewHolder(p0: MovieViewHolder?, p1: Int) {
        val movie: Movie = mList!![p1]
        p0!!.title!!.text=movie.title
        Glide.with(context).load(movie.images.large).into(p0!!.image)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    class MovieViewHolder(itemView: View?,width:Int,height: Int) : ViewHolder(itemView) {
        var title:TextView? = null
        var image:ImageView?=null
        init {
            title=itemView!!.findViewById(R.id.text_title) as TextView
            image=itemView!!.findViewById(R.id.img) as ImageView
            val rootParam : RelativeLayout.LayoutParams= image!!.layoutParams as RelativeLayout.LayoutParams
            rootParam.width=width
            rootParam.height=height
        }
    }
}