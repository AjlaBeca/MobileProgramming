package com.example.a22052024.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a22052024.model.models.CreditCard
import com.example.a22052024.model.repositories.CreditCardRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val creditCardRepository: CreditCardRepository): ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        creditCardRepository.getCreditCards()
            .map {
                HomeUiState(it)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = HomeUiState()
            )

    init{
        viewModelScope.launch {
            val card1 = CreditCard(name = "Credit Card 1", number =  362637, balance = 100.2)
            val card2 = CreditCard(name ="Credit Card 2",number = 634643,balance = -137.8)
            val card3 = CreditCard(name ="Credit Card 3",number = 139213,balance = 2005.37)
            val card4 = CreditCard(name ="Credit Card 4",number = 952954,balance = -56.0)
            Log.d("CreditCardViewModel", "cards added")

            creditCardRepository.addCreditCard(card1)
            creditCardRepository.addCreditCard(card2)
            creditCardRepository.addCreditCard(card3)
            creditCardRepository.addCreditCard(card4)
        }
    }
}


/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val creditCardList: List<CreditCard> = listOf())