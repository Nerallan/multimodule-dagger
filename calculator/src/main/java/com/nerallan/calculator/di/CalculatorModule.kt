package com.nerallan.calculator.di

import android.app.Application
import com.nerallan.calculator.usecase.SumUseCase
import com.nerallan.calculator.utils.IStringProvider
import com.nerallan.calculator.utils.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule(private val application: Application) {

    @Provides
    @Singleton
    fun application(): Application = application


    @Provides
    @Singleton
    fun stringsProvider(application: Application): IStringProvider = StringsProvider(application)

    @Provides
    @Singleton
    fun sumUseCase(stringsProvider: IStringProvider): SumUseCase = SumUseCase(stringsProvider)
}