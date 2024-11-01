package mariscal.damian.descuentosapp.ui.theme.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mariscal.damian.descuentosapp.components.MainButton
import mariscal.damian.descuentosapp.components.MainTextField
import mariscal.damian.descuentosapp.components.SpaceH
import mariscal.damian.descuentosapp.components.TwoCards

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App Descuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }){
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues){
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var totalDescuento by remember { mutableStateOf(0.0) }

        TwoCards(
            title1 = "Total",
            number1 = totalDescuento ,
            title2 = "Descuento" ,
            number2 = precioDescuento
        )


        MainTextField(value = precio, onValueChange = {precio = it}, label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = {descuento = it}, label = "Descuento")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {

        }

        SpaceH()
        MainButton(text = "Limpiar ", color = Color.Red) {

        }
    }
}
