package com.nerallan.calculator.di

import com.nerallan.calculator.usecase.SumUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule {

    @Provides
    @Singleton
    fun sumUseCase(): SumUseCase = SumUseCase()

}