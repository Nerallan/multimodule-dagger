package com.nerallan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.nerallan.calculator.usecase.SumUseCase

class CalculatorActivity : AppCompatActivity() {

    private lateinit var sumUseCase: SumUseCase

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        sumUseCase = SumUseCase()

        bindViews()
        bindListeners()
    }

    private fun calculateSum() {
        val firstNumber = firstNumberEditText.text.toString().toInt()
        val secondNumber = secondNumberEditText.text.toString().toInt()
        val result = sumUseCase.execute(firstNumber, secondNumber)
        resultTextView.text = result.toString()
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            calculateSum()
        }
    }

}