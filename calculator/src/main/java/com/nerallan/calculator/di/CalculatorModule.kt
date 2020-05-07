package com.nerallan.calculator.di

import com.nerallan.calculator.usecase.SumUseCase
import com.nerallan.core.utils.IStringProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule {

    @Provides
    @Singleton
    fun sumUseCase(stringsProvider: IStringProvider): SumUseCase = SumUseCase(stringsProvider)
}