package com.example.a22052024.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a22052024.R
import com.example.a22052024.model.models.CreditCard
import com.example.a22052024.ui.navigation.NavigationDestination
import com.example.a22052024.ui.navigation.TopAppBar
import com.example.a22052024.viewModel.AppViewModelProvider
import com.example.a22052024.viewModel.HomeViewModel

object HomeDestination: NavigationDestination{
    override val route = "dashboard"
    override val title = "Dashboard"
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenWithTopBar(
    navigateToCreditCardPage: (Int) -> Unit
){
    Scaffold(
        topBar = { TopAppBar(titleScreen = CreditCardDestination.title, canNavigateBack = false ) }
    ) {
        HomeScreen(navigateToCreditCardPage = navigateToCreditCardPage)
    }
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateToCreditCardPage: (Int) -> Unit
){
    val uiState by viewModel.homeUiState.collectAsState()
    Log.d("homeScreen", uiState.creditCardList.toString())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome back", fontSize = 28.sp, fontStyle = FontStyle.Italic)
        Spacer(modifier = Modifier.height(20.dp))

        /* TODO: IMPLEMENT LAZY ROW FOR uiState.creditCardList THAT WILL CALL CreditCard FOR EACH ITEM IN LIST */
        LazyRow {
            items(uiState.creditCardList){
                card -> CreditCard(card, navigateToCreditCardPage)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    }
}

@Composable
fun CreditCard(creditCard: CreditCard, navigateToCreditCardPage: (Int) -> Unit){

    /* TODO: CREDIT CARD AS SEEN FROM DOCUMENT */

    Card(
            modifier = Modifier
                .padding(5.dp)
                .width(350.dp)
                .clickable(onClick = {
                navigateToCreditCardPage(creditCard.id)
            }),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ){

        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(
                painter = painterResource(id = R.drawable.outline_verified_user_24),
                contentDescription = "",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp))
            Column(modifier = Modifier.padding(16.dp)){
                Text(text = creditCard.name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = creditCard.number.toString(), fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "${creditCard.balance} KM", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
  //  HomeScreen()
   /* TODO: FOR PARTIAL POINTS IMPLEMENT PREVIEWS */


}

@Preview(showBackground = true)
@Composable
fun HomeScreenCardPreview(){
    //CreditCard()
    /* TODO: FOR PARTIAL POINTS IMPLEMENT PREVIEWS */
}