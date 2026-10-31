**Asignatura:** Desarrollo de Aplicativos Móviles (EE053) 
**Estudiante:** Andres Felipe Vargas Restrepo

KotlinPet Manager es una aplicación móvil  desarrollada para la plataforma Android que
permite realizar la gestión y registro interactivo de pacientes en una clínica veterinaria

La aplicación se compone de una pantalla interactiva que integra un formulario para 
capturar los datos principales de la mascota (nombre, especie/raza, edad en años, contacto
de emergencia y nivel de prioridad o urgencia), permitiendo su inclusión en tiempo 
real dentro de un directorio organizado

El proyecto sigue estrictamente el patrón de arquitectura Model - View - ViewModel (MVVM)
para mantener una separación de responsabilidades clara y modular:

* **Model (`model/Paciente.kt`)**: Define la clase de datos (`data class Paciente`) que 
representa los atributos de cada paciente registrado
* **ViewModel (`viewmodel/PacienteViewModel.kt`)**: Gestiona el estado reactivo de la aplicación 
de forma segura (`private set`). Contiene las funciones para validar e insertar nuevos registros, 
así como para limpiar los campos del formulario tras cada registro exitoso
*  **View (`view/PantallaInicioView.kt`)**: Incluye la estructura general (`Scaffold\`), barra 
superior (`TopAppBar`), formulario interactivo y una lista dinámica en tiempo real utilizando 
`LazyColumn` y tarjetas `ElevatedCard`

* **Lenguaje:** Kotlin 
* **UI Framework:** Jetpack Compose &amp; Material 3 
* **Arquitectura:** MVVM (Model - View - ViewModel) 
* **Manejo de Estado:** Android Lifecycle ViewModel &amp; `mutableStateOf`
* **Control de Versiones:** Git &amp; GitHub
* **Control de Versiones:** Git &amp; GitHub