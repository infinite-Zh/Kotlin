package com.infinite.kotlin.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.infinite.kotlin.R
import com.infinite.kotlin.adapter.MainAdapter
import com.infinite.kotlin.fragment.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {
    var mAdapter: MainAdapter? = null
    val fragmentList: MutableList<Fragment> = mutableListOf()
    val titles: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_title.text="Kotlin"
        tablayout.tabMode=TabLayout.MODE_FIXED
        setUpViewPage()
    }

    fun setUpViewPage() {
        val baseFrg :BaseFragment = BaseFragment()
        fragmentList.add(baseFrg)
        titles.add("正在热播")
        tablayout.setupWithViewPager(vp)
        mAdapter = MainAdapter(supportFragmentManager, fragmentList, titles)
        vp.adapter = mAdapter
    }

}
