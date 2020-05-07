package com.nerallan.calculator.di

import com.nerallan.calculator.ui.CalculatorActivity
import com.nerallan.core.di.CoreModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CalculatorModule::class, CoreModule::class])
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}