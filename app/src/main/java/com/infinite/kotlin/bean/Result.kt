package com.infinite.kotlin.bean

/**
 * Created by 19082 on 2017/6/2.
 */
data class Result<T>(var count:Int,var start:Int,var total:Int,var subjects:T) {

}