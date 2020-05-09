package com.nerallan.multimodule_dagger.di

import com.nerallan.core.di.SubscriptionModule
import com.nerallan.multimodule_dagger.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubscriptionModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}