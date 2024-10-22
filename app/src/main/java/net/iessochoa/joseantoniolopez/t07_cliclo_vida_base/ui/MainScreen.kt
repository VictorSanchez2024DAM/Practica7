package net.iessochoa.joseantoniolopez.t07_cliclo_vida_base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.joseantoniolopez.t07_cliclo_vida_base.ui.theme.T07cliclo_vida_baseTheme

@Composable
fun MainScreen(modifier: Modifier) {
    //iniciamos a 0 el contador
    var contador by remember {mutableStateOf(0)}
    //iniciamos a 20 el slider
    var (seleccion,onValueChangeSlider) = remember { mutableStateOf(20f) }

    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(48.dp))
        Text("$contador",
            style = MaterialTheme.typography.displayLarge,)
        Spacer(modifier = Modifier.height(32.dp))
        //sumamos 1 al contador
        Button(onClick = { contador++ }) {
            Text("+1",
                style = MaterialTheme.typography.displayMedium)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text("${seleccion.toInt()}",
            style = MaterialTheme.typography.displayMedium)
        SimpleSlider(seleccion = seleccion, onValueChange = onValueChangeSlider)
        Spacer(modifier = Modifier.height(32.dp))
        //si el contador es mayor que el slider mostramos fin
        if(contador>seleccion){
            Text(text="Fin",
                style = MaterialTheme.typography.displayLarge,
                color = Color.Red
            )
        }
    }
}
@Composable
fun SimpleSlider(seleccion: Float, onValueChange: (Float) -> Unit) {
    val rango = 1f..40f


    Slider(
        value = seleccion,
        valueRange = rango,
        onValueChange = onValueChange,
    )
}
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    T07cliclo_vida_baseTheme {
        MainScreen(modifier = Modifier)
    }

}