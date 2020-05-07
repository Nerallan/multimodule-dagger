package com.nerallan.core.di

import android.app.Application
import com.nerallan.core.utils.IStringProvider
import com.nerallan.core.utils.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(private val application: Application) {

    @Provides
    @Singleton
    fun stringsProvider(): IStringProvider = StringsProvider(application)
}