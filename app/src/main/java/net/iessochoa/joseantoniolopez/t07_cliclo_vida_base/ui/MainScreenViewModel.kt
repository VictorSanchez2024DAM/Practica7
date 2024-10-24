package net.iessochoa.joseantoniolopez.t07_cliclo_vida_base.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//declaramos el estado de la pantalla principal
data class MainScreenUiState(
    val contador: Int = 0,
    val slider: Float = 20f,
    val isFin: Boolean = false
)
//declaramos el viewmodel de la pantalla principal
class MainScreenViewModel :ViewModel() {
    //declaramos el estado privado que permite modificar su valor solo desde esta clase
    private val _uiState= MutableStateFlow(MainScreenUiState())
    //declaramos el estado público que permite leer su valor desde cualquier clase
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    //declaramos la función que incrementa el contador
    var nombreTextField by mutableStateOf("")
    val onValueChangeNombreTextField: (String) -> Unit = { nombreTextField = it }

    //declaramos la función que incrementa el contador
    fun sumaUno(){
    //actualizamos el estado con el nuevo valor
        _uiState.update { estadoActual->
    //devolvemos un nuevo estado con el valor incrementado
            estadoActual.copy(
                contador = estadoActual.contador+1,
                isFin=(estadoActual.contador+1) > estadoActual.slider
            )
        }
    }
    //declaramos la función que actualiza el valor del slider
    fun onSliderValueChanged(newValue: Float) {
    //actualizamos el estado con el nuevo valor al cambiar el slider
        _uiState.update { estadoActual->
            estadoActual.copy(
                slider = newValue,
                isFin = (estadoActual.contador)>newValue
            )
        }
    }
}