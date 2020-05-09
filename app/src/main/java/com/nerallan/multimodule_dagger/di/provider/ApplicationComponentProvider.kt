package com.nerallan.multimodule_dagger.di.provider

import com.nerallan.multimodule_dagger.di.ApplicationComponent

interface ApplicationComponentProvider {
    fun getApplicationComponent(): ApplicationComponent
}