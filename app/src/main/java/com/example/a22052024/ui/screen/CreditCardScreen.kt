package com.example.a22052024.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a22052024.R
import com.example.a22052024.ui.navigation.NavigationDestination
import com.example.a22052024.ui.navigation.TopAppBar
import com.example.a22052024.viewModel.AppViewModelProvider
import com.example.a22052024.viewModel.CreditCardViewModel
import com.example.a22052024.ui.screen.HomeScreen

object CreditCardDestination: NavigationDestination {
    override val route = "card"
    override val title = "Credit Card Info"
    const val cardIdArg = "cardID"
    val routeWithArgs = "$route/{$cardIdArg}"

}

/* TODO IMPLEMENT CreditCardScreenWithTopBar FUNCTION FOR SCAFFOLD WITH TopAppBar */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreditCardScreenWithTopBar(
    viewModel: CreditCardViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateBack: () -> Unit)

{
    Scaffold(
        topBar = {
            TopAppBar(
                titleScreen = CreditCardDestination.title, canNavigateBack = true, navigateBack = navigateBack)
        },
        ){
        CreditCardScreen(viewModel)
    }
}

/* TODO IMPLEMENT CreditCardScreen SCREEN TO VIEW ONE CREDIT CARD DETAILS AS SEEN ON DOCUMENT */
@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel){
    val uiState = viewModel.creditCardUiState
    val cardDetails = uiState.creditCardDetails

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 80.dp, end = 16.dp, start = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Card(
            modifier = Modifier
                .padding(5.dp)
                .width(350.dp),
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
                    Text(text = cardDetails.name)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = cardDetails.number.toString(), fontWeight = FontWeight.Light)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "${cardDetails.balance} KM", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = buildAnnotatedString {
            append("Credit Card name: ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append(cardDetails.name)
            }
        }, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(buildAnnotatedString {
            append("Credit Card number: ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append(cardDetails.number.toString())
            }
        }, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(buildAnnotatedString {
            append("Credit Card balance: ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append(cardDetails.balance.toString())
            }
        }, fontSize = 22.sp)
    }
}


/* TODO FOR PARTIAL POINTS PLEASE IMPLEMENT PREVIEWS */

@Preview(showBackground = true)
@Composable
fun CreditCardScreenPreview(){
    //  CreditCardScreen()



}