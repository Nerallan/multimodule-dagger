package com.nerallan.calculator.di.provider

import com.nerallan.calculator.di.CalculatorComponent

interface CalculatorComponentProvider {
    fun getCalculatorComponent(): CalculatorComponent
}