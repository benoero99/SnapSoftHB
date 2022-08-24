package com.example.snapsofthb

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import dagger.hilt.android.AndroidEntryPoint
import com.example.snapsofthb.ui.movie.MovieFragment

@AndroidEntryPoint
class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(co.zsmb.rainbowcake.R.layout.activity_main)

        if(savedInstanceState == null) {
            navigator.add(MovieFragment())
        }


    }
}