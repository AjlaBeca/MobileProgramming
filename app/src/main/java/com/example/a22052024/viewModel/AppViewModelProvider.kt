package com.example.a22052024.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a22052024.CreditCardApplication
import com.example.a22052024.ui.screen.HomeScreen

object AppViewModelProvider {
    val Factory = viewModelFactory {

        /* TODO INITIALIZE HomeViewModel */

        initializer {
            HomeViewModel(
                studentApplication().container.creditCardRepository
                )
        }



        initializer {
            CreditCardViewModel(
                studentApplication().container.creditCardRepository,
                this.createSavedStateHandle()
            )
        }
    }
}

fun CreationExtras.studentApplication(): CreditCardApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as CreditCardApplication)