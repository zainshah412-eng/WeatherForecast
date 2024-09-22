package com.example.weather.test

import isNumber

object Validator {
    fun validateInput(searchWord: String): Boolean {
        return (!(searchWord.isNullOrEmpty() && isNumber(searchWord)) && (searchWord.length < 50))
    }
}