package com.example.a22052024.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a22052024.model.models.CreditCard
import com.example.a22052024.model.repositories.CreditCardRepository
import com.example.a22052024.ui.screen.CreditCardDestination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CreditCardViewModel(private val creditCardRepository: CreditCardRepository,savedStateHandle: SavedStateHandle): ViewModel() {
    private val cardId: Int = checkNotNull(savedStateHandle[CreditCardDestination.cardIdArg])

     /**
     * Holds current item ui state
     */
    var creditCardUiState by mutableStateOf(CreditCardUiState())
        private set

    init {
        viewModelScope.launch {

            /* TODO: UPDATE creditCardUiState VARIABLE WITH FUNCTION FROM REPOSITORY CALLED getCreditCard */

            creditCardUiState = creditCardRepository.getCreditCard(cardId).filterNotNull().first().toCreditCardUiState()

        }
    }

}