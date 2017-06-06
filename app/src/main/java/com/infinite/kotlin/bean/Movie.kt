package com.infinite.kotlin.bean

/**
 * Created by 19082 on 2017/6/2.
 */
data class Movie(var title :String ,var images:Image)

data class Image(var small:String,var medium:String,var large:String)