package com.pratamawijaya.exoplayerexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.btnSimpleVideo

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnSimpleVideo.setOnClickListener { startActivity(Intent(this, SimpleVideoActivity::class.java)) }
    }
}
