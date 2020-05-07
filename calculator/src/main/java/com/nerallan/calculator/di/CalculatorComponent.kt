package com.nerallan.calculator.di

import com.nerallan.calculator.ui.CalculatorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CalculatorModule::class])
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}