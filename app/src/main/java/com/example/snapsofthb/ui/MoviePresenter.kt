package com.example.snapsofthb.ui

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class MoviePresenter @Inject constructor() {
    suspend fun getData(): String = withIOContext {
        ""
    }
}