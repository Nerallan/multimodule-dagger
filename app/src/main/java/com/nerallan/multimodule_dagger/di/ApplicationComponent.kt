package com.nerallan.multimodule_dagger.di

import com.nerallan.core.di.CoreModule
import com.nerallan.core.di.SubscriptionModule
import com.nerallan.multimodule_dagger.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubscriptionModule::class, CoreModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}