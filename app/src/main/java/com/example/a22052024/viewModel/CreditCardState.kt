package com.example.a22052024.viewModel

import com.example.a22052024.model.models.CreditCard

data class CreditCardDetails(
    val id: Int = 0,
    val name: String = "",
    val number: Int = 0,
    val balance: Double = 0.0
)

data class CreditCardUiState(
    val creditCardDetails: CreditCardDetails = CreditCardDetails(),
)

fun CreditCard.toCreditCardDetails() = CreditCardDetails(
    id = id,
    name = name,
    number = number,
    balance = balance
)

fun CreditCard.toCreditCardUiState(): CreditCardUiState = CreditCardUiState(
    creditCardDetails = this.toCreditCardDetails()
)