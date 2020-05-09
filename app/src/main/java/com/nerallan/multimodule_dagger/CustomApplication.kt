package com.nerallan.multimodule_dagger

import android.app.Application
import com.nerallan.calculator.di.CalculatorComponent
import com.nerallan.calculator.di.DaggerCalculatorComponent
import com.nerallan.calculator.di.provider.CalculatorComponentProvider
import com.nerallan.core.di.CoreModule
import com.nerallan.multimodule_dagger.di.ApplicationComponent
import com.nerallan.multimodule_dagger.di.DaggerApplicationComponent
import com.nerallan.multimodule_dagger.di.provider.ApplicationComponentProvider

class CustomApplication : Application(),
    ApplicationComponentProvider,
    CalculatorComponentProvider {

    private val coreModule: CoreModule by lazy {
        CoreModule(this)
    }

    override fun getApplicationComponent(): ApplicationComponent = DaggerApplicationComponent
        .builder()
        .coreModule(coreModule)
        .build()

    override fun getCalculatorComponent(): CalculatorComponent {
        return DaggerCalculatorComponent.builder()
            .coreModule(coreModule)
            .build()
    }
}

