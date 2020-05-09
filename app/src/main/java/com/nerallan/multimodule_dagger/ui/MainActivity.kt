package com.nerallan.multimodule_dagger.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nerallan.calculator.ui.CalculatorActivity
import com.nerallan.core.modes.AppSubscription
import com.nerallan.multimodule_dagger.R
import com.nerallan.multimodule_dagger.di.provider.ApplicationComponentProvider
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appSubscription: AppSubscription

    private lateinit var subscriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApplicationComponentProvider)
            .getApplicationComponent()
            .inject(this)

        bindViews()
        bindListeners()

        showSubscription()
    }

    private fun bindViews() {
        subscriptionTextView = findViewById(R.id.subscription_type_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.calculator_button).setOnClickListener {
            startCalculatorActivity()
        }
    }
    private fun showSubscription() {
        subscriptionTextView.text = appSubscription.getUserSubscription()
    }
    private fun startCalculatorActivity() {
        startActivity(
            Intent(this, CalculatorActivity::class.java)
        )
    }
}