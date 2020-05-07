package com.nerallan.calculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.nerallan.calculator.R
import com.nerallan.calculator.di.DaggerCalculatorComponent
import com.nerallan.calculator.usecase.SumUseCase
import javax.inject.Inject

class CalculatorActivity : AppCompatActivity() {
    data class NumPair(val firstNum: Int, val secondNum: Int)

    @Inject
    lateinit var sumUseCase: SumUseCase

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        DaggerCalculatorComponent
            .builder()
            .build()
            .inject(this)

        bindViews()
        bindListeners()
    }

    private fun getInputNums(): NumPair{
        val firstNumber = firstNumberEditText.text.toString().toInt()
        val secondNumber = secondNumberEditText.text.toString().toInt()
        return NumPair(firstNumber, secondNumber)
    }

    private fun calculateSum(numPair: NumPair): String {
        val (firstNumber, secondNumber) = numPair
        val result = sumUseCase.execute(firstNumber, secondNumber)
        return result.toString()
    }

    private fun showResult(result: String) {
        resultTextView.text = result
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            val result = calculateSum(getInputNums())
            showResult(result)
        }
    }

}