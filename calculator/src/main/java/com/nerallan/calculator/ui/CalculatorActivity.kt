package com.nerallan.calculator.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nerallan.calculator.R
import com.nerallan.calculator.di.provider.CalculatorComponentProvider
import com.nerallan.calculator.usecase.SumUseCase
import com.nerallan.calculator.usecase.SumUseCase.Result
import com.nerallan.calculator.usecase.SumUseCase.Result.Failure
import com.nerallan.calculator.usecase.SumUseCase.Result.Success
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

        (application as CalculatorComponentProvider)
            .getCalculatorComponent()
            .inject(this)

        bindViews()
        bindListeners()
    }

    private fun getInputNums(): NumPair {
        val firstNumber = firstNumberEditText.text.toString().toInt()
        val secondNumber = secondNumberEditText.text.toString().toInt()
        return NumPair(firstNumber, secondNumber)
    }

    private fun calculateSum(numPair: NumPair): Result {
        val (firstNumber, secondNumber) = numPair
        return sumUseCase.execute(firstNumber, secondNumber)
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun showResult(result: String) {
        resultTextView.text = result
    }

    private fun showFailureMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            calculateSum(getInputNums()).let {
                when (it) {
                    is Success -> showResult(it.value.toString())
                    is Failure -> showFailureMessage(it.message)
                }
            }

        }
    }
}