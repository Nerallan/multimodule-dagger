package com.nerallan.core.di

import com.nerallan.core.modes.AppSubscription
import com.nerallan.core.modes.IAppSubscription
import com.nerallan.core.utils.IStringProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CoreModule::class])
class SubscriptionModule {

    @Provides
    @Singleton
    fun appSubscription(stringsProvider: IStringProvider): IAppSubscription =
        AppSubscription(stringsProvider)
}