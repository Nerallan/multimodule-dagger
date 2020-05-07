package com.nerallan.core.utils

import androidx.annotation.StringRes

interface IStringProvider {
    fun getString(@StringRes id: Int): String
}