package com.nerallan.calculator.usecase

import com.nerallan.calculator.R
import com.nerallan.calculator.utils.IStringProvider

class SumUseCase(private val stringsProvider: IStringProvider) {

    fun execute(firstNumber: Int, secondNumber: Int): Result {
        return if (firstNumber > 0 && secondNumber > 0) {
            Result.Success(firstNumber + secondNumber)
        } else {
            Result.Failure(stringsProvider.getString(R.string.both_number_must_be_positive))
        }
    }

    sealed class Result {
        class Success(val value: Int) : Result()
        class Failure(val message: String) : Result()
    }
}