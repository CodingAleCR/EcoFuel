package com.codingalecr.refuel_kotlin.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

/**
 * Created by aulate on 5/1/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        if (withToolbar()) {
            setSupportActionBar(toolbar)
        }
        init()
    }

    abstract fun withToolbar(): Boolean
    abstract fun getLayout(): Int

    fun init() {
        initViewModel()
        initObj()
        initUI()
        initObservers()
    }

    abstract fun initObj()
    abstract fun initViewModel()
    abstract fun initObservers()
    abstract fun initUI()
}