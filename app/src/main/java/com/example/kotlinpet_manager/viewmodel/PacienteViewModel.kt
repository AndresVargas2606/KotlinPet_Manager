package com.example.kotlinpet_manager.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kotlinpet_manager.model.Paciente
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class  PacienteViewModel : ViewModel(){
    var pacientes by mutableStateOf<List<Paciente>>(emptyList())
        private  set
    var nombre by mutableStateOf("")
        private set
    var especie by mutableStateOf("")
        private set
    var edad by mutableStateOf("")
        private set
    var contactoEmergencia by mutableStateOf("")
        private set
    var esUrgencia by mutableStateOf(false)
        private set



    fun onNombreChange(nuevoNombre : String){
        nombre = nuevoNombre
    }
    fun onEspecieChange(nuevaEspecie : String){
        especie = nuevaEspecie
    }
    fun onEdadChange(nuevaEdad: String){
        edad = nuevaEdad
    }
    fun onContactoEmergeniaChange(nuevoContacto : String){
        contactoEmergencia = nuevoContacto
    }
    fun onEsUrgenciaChange(nuevaUrgencia : Boolean){
        esUrgencia = nuevaUrgencia
    }



    fun agregarPaciente(){
        if (nombre.isNotBlank() && especie.isNotBlank() && edad.isNotBlank()){
            val edadInt = edad.toIntOrNull() ?: 0
            val nuevoPaciente = Paciente(
                id = (pacientes.size + 1).toString(),
                nombre = nombre,
                especie = especie,
                edad = edadInt,
                contactoEmergencia = contactoEmergencia,
                esUrgencia = esUrgencia
            )
            pacientes = pacientes + nuevoPaciente
            limpiarFormulario()
        }
    }



    fun limpiarFormulario(){
        nombre = ""
        especie = ""
        edad = ""
        contactoEmergencia = ""
        esUrgencia = false
    }
}