package net.iessochoa.joseantoniolopez.t07_cliclo_vida_base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.joseantoniolopez.t07_cliclo_vida_base.ui.theme.T07cliclo_vida_baseTheme
@Composable
//declaramos la función MainScreen
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel = viewModel(),
    modifier: Modifier) {
    /*
    //iniciamos a 0 el contador
    var contador by remember {mutableStateOf(0)}
    //iniciamos a 20 el slider
    var (seleccion,onValueChangeSlider) = remember { mutableStateOf(20f) }
     */


    //recogemos el estado del viewmodel. Cuando cambia, se actualizará automáticamente
    val uiState by mainScreenViewModel.uiState.collectAsState()

    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(48.dp))
        Text(
            "${uiState.contador}",
            style = MaterialTheme.typography.displayLarge,
        )
        Spacer(modifier = Modifier.height(32.dp))
        //sumamos 1 al contador
        Button(onClick =
            mainScreenViewModel::sumaUno) {
            Text("+1",
                style = MaterialTheme.typography.displayMedium)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text("${uiState.slider.toInt()}",
            style = MaterialTheme.typography.displayMedium)
        SimpleSlider(seleccion =
            uiState.slider,
            onValueChange = {mainScreenViewModel.onSliderValueChanged(it)}
        )
        Spacer(modifier = Modifier.height(32.dp))
        //si el contador es mayor que el slider mostramos fin
        if(uiState.isFin){
            Text(text="Limite superado ${mainScreenViewModel.nombreTextField}",
                style = MaterialTheme.typography.displayLarge,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        //mostramos el nombre introducido
        OutlinedTextField(
            value = mainScreenViewModel.nombreTextField,
            onValueChange = mainScreenViewModel.onValueChangeNombreTextField,
            label = { Text("Introduce tu nombre") }
        )
    }
}
//declaramos la función SimpleSlider
@Composable
fun SimpleSlider(seleccion: Float, onValueChange: (Float) -> Unit) {
    val rango = 1f..40f


    Slider(
        value = seleccion,
        valueRange = rango,
        onValueChange = onValueChange,
    )
}
//mostramos el tema de la pantalla
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    T07cliclo_vida_baseTheme {
        MainScreen(modifier = Modifier)
    }

}