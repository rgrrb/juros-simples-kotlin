package com.example.gestaodeestado.juros

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gestaodeestado.calculos.calcularJuros
import com.example.gestaodeestado.calculos.calcularMontante
import kotlin.text.toDouble

class JurosScreenViewModel: ViewModel() {

    private val _capitalState = MutableLiveData<String>()
    var capital: LiveData<String> = _capitalState

    private val _taxaState = MutableLiveData<String>()
    var taxa: LiveData<String> = _taxaState

    private val _tempoState = MutableLiveData<String>()
    var tempo: LiveData<String> = _tempoState

    private val _jurosState = MutableLiveData<Double>()

    var juros: LiveData<Double> = _jurosState

    private val _montanteState = MutableLiveData<Double>()

    var montante: LiveData<Double> = _montanteState

    fun onCapitalChanged(newValue: String){
        _capitalState.value = newValue
    }

    fun onTaxaChanged(newValue: String){
        _taxaState.value = newValue
    }

    fun onTempoChanged(newValue: String){
        _tempoState.value = newValue
    }

    fun calcularJurosInvestimentos(){
        _jurosState.value = calcularJuros(
            capital = _capitalState.value!!.toDouble(),
            taxa = _taxaState.value!!.toDouble(),
            tempo = _tempoState.value!!.toDouble()
        )
    }

    fun calcularMontanteInvestimento(){
        _montanteState.value = calcularMontante(
            capital = _capitalState.value!!.toDouble(),
            juros = _jurosState.value!!
        )
    }



}