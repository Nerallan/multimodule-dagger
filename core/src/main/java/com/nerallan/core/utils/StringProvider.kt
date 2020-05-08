package com.nerallan.core.utils

import android.app.Application
import androidx.annotation.StringRes

class StringsProvider(private val application: Application) : IStringProvider {
    override fun getString(@StringRes id: Int): String = application.getString(id)
}