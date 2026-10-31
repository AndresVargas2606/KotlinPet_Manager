package com.example.kotlinpet_manager.view

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinpet_manager.model.Paciente

import com.example.kotlinpet_manager.viewmodel.PacienteViewModel

@OptIn(ExperimentalMaterial3Api :: class)
@Composable

fun PantallaInicioView(
    viewModel: PacienteViewModel = viewModel()
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("KotlinPet Manager") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer

                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Registro de Paciente",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier =  Modifier.height(12.dp))

            OutlinedTextField(
                value = viewModel.nombre,
                onValueChange =  {viewModel.onNombreChange(it)},
                label = {Text("Nombre de la mascota")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.especie,
                onValueChange = {viewModel.onEspecieChange(it)},
                label = {Text("Espeice / Raza")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.edad,
                onValueChange = {viewModel.onEdadChange(it)},
                label = {Text("Edad (años)")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.contactoEmergencia,
                onValueChange = {viewModel.onContactoEmergeniaChange(it)},
                label = {Text("Contacto de emergencia")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment =  Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = viewModel.esUrgencia,
                    onCheckedChange = {viewModel.onEsUrgenciaChange(it)}
                )
                Text(text = "requiere atencion inmediata (Urgencia)")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {viewModel.agregarPaciente()},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar Paciente")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Lista de Paceintes Registrados (${viewModel.pacientes.size})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewModel.pacientes){ paciente ->
                    TarjetaPaciente(paciente = paciente)
                }
            }
        }

    }
}

@Composable
fun TarjetaPaciente(paciente: Paciente){
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = paciente.nombre,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                if (paciente.esUrgencia){
                    Text(
                        text = "URGENCIA",
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Especie: ${paciente.especie}")
            Text(text = "Edad: ${paciente.edad} año(s)")
            if (paciente.contactoEmergencia.isNotBlank()){
                Text(text = "Contacto: ${paciente.contactoEmergencia}")
            }
        }
    }
}