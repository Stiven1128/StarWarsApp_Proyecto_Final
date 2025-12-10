# 🌟 Star Wars Universe Explorer

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

Una aplicación Android moderna que permite explorar el universo de Star Wars, mostrando información sobre personajes, películas, planetas, naves espaciales y vehículos usando la API de SWAPI.

## 📸 Características

- ⭐ **Interfaz temática de Star Wars** con colores icónicos (amarillo y negro)
- 🎨 **Animaciones fluidas** con efectos de brillo y fondo de estrellas
- 👥 **Exploración de personajes** con búsqueda en tiempo real
- 🎬 **Información detallada de películas** de la saga
- 🪐 **Catálogo de planetas** del universo Star Wars
- 🚀 **Naves espaciales y vehículos** con especificaciones técnicas
- 📱 **Diseño responsive** y Material Design 3
- 🌐 **Conexión a API REST** (SWAPI)

## 🏗️ Arquitectura

La aplicación sigue el patrón **MVVM (Model-View-ViewModel)** con arquitectura limpia:

```
📦 com.example.starwarsapp_proyecto_final
 ┣ 📂 data
 ┃ ┣ 📂 model          # 5 modelos + 5 responses
 ┃ ┃ ┣ 📜 Person.kt
 ┃ ┃ ┣ 📜 Film.kt
 ┃ ┃ ┣ 📜 Planet.kt
 ┃ ┃ ┣ 📜 Starship.kt
 ┃ ┃ ┗ 📜 Vehicle.kt
 ┃ ┣ 📂 remote         # API configuration
 ┃ ┃ ┣ 📜 StarWarsApiService.kt
 ┃ ┃ ┗ 📜 RetrofitInstance.kt
 ┃ ┗ 📂 repository     # Repository pattern
 ┃   ┗ 📜 StarWarsRepository.kt
 ┣ 📂 viewmodel        # 7 ViewModels
 ┃ ┣ 📜 PeopleViewModel.kt
 ┃ ┣ 📜 FilmsViewModel.kt
 ┃ ┣ 📜 PlanetsViewModel.kt
 ┃ ┣ 📜 StarshipsViewModel.kt
 ┃ ┣ 📜 VehiclesViewModel.kt
 ┃ ┣ 📜 PersonDetailViewModel.kt (dentro de PersonDetailScreen.kt)
 ┃ ┗ 📜 FilmDetailViewModel.kt (dentro de FilmDetailScreen.kt)
 ┣ 📂 ui
 ┃ ┣ 📂 screens        # 8 pantallas
 ┃ ┃ ┣ 📜 HomeScreen.kt
 ┃ ┃ ┣ 📜 PeopleListScreen.kt
 ┃ ┃ ┣ 📜 PersonDetailScreen.kt
 ┃ ┃ ┣ 📜 FilmsListScreen.kt
 ┃ ┃ ┣ 📜 FilmDetailScreen.kt
 ┃ ┃ ┣ 📜 PlanetsListScreen.kt
 ┃ ┃ ┣ 📜 StarshipsListScreen.kt
 ┃ ┃ ┗ 📜 VehiclesListScreen.kt
 ┃ ┣ 📂 components     # 11 componentes reutilizables
 ┃ ┃ ┣ 📜 CharacterAvatar.kt
 ┃ ┃ ┣ 📜 DeathStarIcon.kt
 ┃ ┃ ┣ 📜 ErrorScreen.kt
 ┃ ┃ ┣ 📜 GlowingCard.kt
 ┃ ┃ ┣ 📜 InfoRow.kt
 ┃ ┃ ┣ 📜 LoadingScreen.kt
 ┃ ┃ ┣ 📜 SearchBar.kt
 ┃ ┃ ┣ 📜 SectionTitle.kt
 ┃ ┃ ┣ 📜 StarfieldBackground.kt
 ┃ ┃ ┣ 📜 StarWarsButton.kt
 ┃ ┃ ┗ 📜 StarWarsCard.kt
 ┃ ┣ 📂 navigation     # Navegación
 ┃ ┃ ┗ 📜 NavGraph.kt
 ┃ ┗ 📂 theme          # Tema personalizado
 ┃   ┣ 📜 Color.kt
 ┃   ┣ 📜 Theme.kt
 ┃   ┗ 📜 Type.kt
 ┗ 📜 MainActivity.kt  # Actividad principal
```

## 🛠️ Tecnologías y Librerías

### Core
- **Kotlin** - Lenguaje de programación
- **Jetpack Compose** - UI moderna y declarativa
- **Material Design 3** - Componentes de diseño

### Networking
- **Retrofit 2.9.0** - Cliente HTTP
- **Gson Converter** - Serialización JSON

### Arquitectura
- **ViewModel** - Gestión de estado UI
- **Kotlin Coroutines & Flow** - Programación asíncrona
- **StateFlow** - Manejo de estado reactivo

### Navegación
- **Navigation Compose** - Navegación entre pantallas

### Otros
- **Coil** - Carga de imágenes (preparado para uso futuro)

## 📋 Requisitos

- Android Studio Hedgehog o superior
- Kotlin 1.9+
- Minimum SDK: API 24 (Android 7.0)
- Target SDK: API 34 (Android 14)
- Conexión a Internet

## 🚀 Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/Stiven1128/StarWarsApp_Proyecto_Final.git
cd StarWarsApp_Proyecto_Final
```

2. **Abrir en Android Studio**
```
File → Open → Seleccionar la carpeta del proyecto
```

3. **Sincronizar dependencias**
```
El proyecto sincronizará automáticamente las dependencias de Gradle
```

4. **Ejecutar la aplicación**
```
Run → Run 'app' o presiona Shift + F10
```

## 📱 Funcionalidades Detalladas

### 🏠 Pantalla Principal (HomeScreen)
- Logo animado de Star Wars con efecto de pulso
- Fondo de estrellas animadas
- Menú de navegación con 5 opciones principales
- Ícono animado de Death Star

### 👥 Personajes (People)
**Lista:**
- Búsqueda en tiempo real
- Avatares circulares con iniciales
- Tarjetas con efecto de brillo
- Información básica (altura, peso)

**Detalle:**
- Avatar grande del personaje
- Información completa (nombre, altura, peso, género, año de nacimiento)
- Contador de apariciones en películas
- Diseño con tarjetas brillantes

### 🎬 Películas (Films)
**Lista:**
- Número de episodio destacado
- Título de la película
- Fecha de estreno
- Director

**Detalle:**
- Información completa del episodio
- Sinopsis (opening crawl)
- Productor y director
- Número de personajes

### 🪐 Planetas (Planets)
- Nombre del planeta
- Clima y terreno
- Población
- Diámetro

### 🚀 Naves Espaciales (Starships)
- Nombre y modelo
- Fabricante
- Costo en créditos
- Longitud
- Capacidad de tripulación y pasajeros

### 🚗 Vehículos (Vehicles)
- Especificaciones similares a las naves
- Información técnica detallada

## 🎨 Diseño y UX

### Componentes Reutilizables (11 componentes)

La aplicación cuenta con 11 componentes personalizados que garantizan consistencia y reutilización:

| Componente | Descripción | Uso |
|## 📊 Estadísticas del Proyecto

### Archivos y Líneas de Código

| Categoría | Archivos | Descripción |
|-----------|----------|-------------|
| **Data Layer** | 13 | Models, API Service, Retrofit, Repository |
| **ViewModels** | 7 | Lógica de negocio y gestión de estado |
| **Screens** | 8 | Pantallas de la aplicación |
| **Components** | 11 | Componentes reutilizables |
| **Navigation** | 1 | Sistema de navegación |
| **Theme** | 3 | Colores, tipografía y tema |
| **Config** | 3 | MainActivity, Manifest, Gradle |
| **TOTAL** | **46 archivos** | Proyecto completo |

### Componentes Detallados

**11 Componentes Personalizados:**
1. CharacterAvatar.kt (~30 líneas)
2. DeathStarIcon.kt (~40 líneas)
3. ErrorScreen.kt (~50 líneas)
4. GlowingCard.kt (~45 líneas)
5. InfoRow.kt (~50 líneas)
6. LoadingScreen.kt (~40 líneas)
7. SearchBar.kt (~50 líneas)
8. SectionTitle.kt (~20 líneas)
9. StarfieldBackground.kt (~60 líneas)
10. StarWarsButton.kt (~50 líneas)
11. StarWarsCard.kt (~35 líneas)

**Total aproximado:** ~470 líneas de código en componentes reutilizables

------------|-------------|-----|
| **CharacterAvatar.kt** | Avatar circular con iniciales y gradiente | Lista y detalle de personajes |
| **DeathStarIcon.kt** | Ícono de Death Star con rotación animada | Pantalla principal |
| **ErrorScreen.kt** | Pantalla de error con botón de reintentar | Manejo de errores en todas las pantallas |
| **GlowingCard.kt** | Tarjeta con borde brillante animado | Listas de personajes y películas |
| **InfoRow.kt** | Fila de información con icono y divisor | Pantallas de detalle |
| **LoadingScreen.kt** | Pantalla de carga con estrella animada | Estados de carga |
| **SearchBar.kt** | Barra de búsqueda estilizada | Lista de personajes |
| **SectionTitle.kt** | Título de sección destacado | Separación de contenido |
| **StarfieldBackground.kt** | Fondo de estrellas animadas (100 estrellas) | Todas las pantallas |
| **StarWarsButton.kt** | Botón personalizado con estilo SW | Pantalla principal y navegación |
| **StarWarsCard.kt** | Tarjeta estándar con diseño temático | Listas de planetas, naves y vehículos |

### Paleta de Colores
```kotlin
// Colores principales
StarWarsYellow = #FFE81F  // Amarillo icónico
StarWarsBlack = #000000   // Negro profundo
LightSideBlue = #4A9EFF   // Azul lado luminoso
DarkSideRed = #FF0000     // Rojo lado oscuro
```

### Componentes Personalizados (11 Componentes)

1. **CharacterAvatar.kt** - Avatares circulares con iniciales y gradiente
2. **DeathStarIcon.kt** - Ícono animado de Death Star rotando
3. **ErrorScreen.kt** - Pantalla de error con botón de reintentar
4. **GlowingCard.kt** - Tarjetas con borde brillante animado
5. **InfoRow.kt** - Filas de información con iconos y divisores
6. **LoadingScreen.kt** - Pantalla de carga con estrella animada
7. **SearchBar.kt** - Barra de búsqueda estilizada con iconos
8. **SectionTitle.kt** - Títulos de sección destacados
9. **StarfieldBackground.kt** - Fondo de estrellas animadas parpadeantes
10. **StarWarsButton.kt** - Botones personalizados con estilo Star Wars
11. **StarWarsCard.kt** - Tarjetas con diseño temático y bordes
12. **StarWarsLogo.kt** - Logo animado con efecto de pulso

### Animaciones
- **Pulso continuo** en el logo (scale 0.95 - 1.05)
- **Estrellas parpadeantes** - 100 estrellas con brillo variable
- **Brillo dinámico** en GlowingCard (alpha 0.3 - 0.7)
- **Rotación 360°** del DeathStarIcon (10 segundos)
- **Transiciones suaves** entre pantallas con Navigation Compose

### Características de los Componentes

**StarfieldBackground:**
- 100 estrellas generadas aleatoriamente
- Cada estrella con tamaño y velocidad única
- Efecto de parpadeo sinusoidal
- Renderizado con Canvas de Compose

**GlowingCard:**
- Animación infinita en el borde
- Gradiente lineal de colores
- Transición de 1.5 segundos
- Modo reversible (ReviseMode.Reverse)

**CharacterAvatar:**
- Gradiente radial desde primary a secondary
- Muestra las primeras 2 letras del nombre
- Tamaño configurable (default 80dp)
- Forma circular perfecta

**DeathStarIcon:**
- Canvas personalizado 60x60dp
- Círculo principal + línea ecuatorial
- Punto de "láser" posicionado
- Animación de rotación continua

## 🔌 API Integration

La aplicación consume la API pública de Star Wars (SWAPI):

**Base URL:** `https://swapi.dev/api/`

**Endpoints utilizados:**
- `GET /people/` - Lista de personajes
- `GET /people/{id}/` - Detalle de personaje
- `GET /films/` - Lista de películas
- `GET /films/{id}/` - Detalle de película
- `GET /planets/` - Lista de planetas
- `GET /starships/` - Lista de naves
- `GET /vehicles/` - Lista de vehículos

### Modelos de Datos

```kotlin
data class Person(
    val name: String,
    val height: String,
    val mass: String,
    val gender: String,
    val birth_year: String,
    val homeworld: String,
    val films: List<String>,
    val url: String
)
```

## 🧪 Estructura del Código

### 1. Capa de Datos (Data Layer)

**Models:**
- `Person.kt` - Modelo de personaje
- `Film.kt` - Modelo de película
- `Planet.kt` - Modelo de planeta
- `Starship.kt` - Modelo de nave espacial
- `Vehicle.kt` - Modelo de vehículo

**Remote:**
- `StarWarsApiService.kt` - Interface con endpoints
- `RetrofitInstance.kt` - Configuración de Retrofit

**Repository:**
- `StarWarsRepository.kt` - Repositorio único para todas las llamadas

### 2. Capa de Presentación (Presentation Layer)

**ViewModels:**
- `PeopleViewModel.kt` - Lógica de personajes
- `FilmsViewModel.kt` - Lógica de películas
- `PlanetsViewModel.kt` - Lógica de planetas
- `StarshipsViewModel.kt` - Lógica de naves
- `VehiclesViewModel.kt` - Lógica de vehículos
- `PersonDetailViewModel.kt` - Detalle de personaje
- `FilmDetailViewModel.kt` - Detalle de película

**Screens:**
- `HomeScreen.kt` - Pantalla principal
- `PeopleListScreen.kt` - Lista de personajes
- `PersonDetailScreen.kt` - Detalle de personaje
- `FilmsListScreen.kt` - Lista de películas
- `FilmDetailScreen.kt` - Detalle de película
- `PlanetsListScreen.kt` - Lista de planetas
- `StarshipsListScreen.kt` - Lista de naves
- `VehiclesListScreen.kt` - Lista de vehículos

### 3. Navegación

**NavGraph.kt:**
```kotlin
- home → Pantalla principal
- people → Lista de personajes
- person/{id} → Detalle de personaje
- films → Lista de películas
- film/{id} → Detalle de película
- planets → Lista de planetas
- starships → Lista de naves
- vehicles → Lista de vehículos
```

## 📊 Manejo de Estado

La aplicación usa `StateFlow` para manejo reactivo de estado:

```kotlin
private val _people = MutableStateFlow<List<Person>>(emptyList())
val people: StateFlow<List<Person>> = _people

private val _isLoading = MutableStateFlow(false)
val isLoading: StateFlow<Boolean> = _isLoading

private val _error = MutableStateFlow<String?>(null)
val error: StateFlow<String?> = _error
```

**Estados manejados:**
- ✅ **Success** - Datos cargados correctamente
- ⏳ **Loading** - Cargando datos
- ❌ **Error** - Error en la carga con mensaje

## 🎯 Buenas Prácticas Implementadas

1. ✅ **Arquitectura MVVM** - Separación de responsabilidades
2. ✅ **Single Source of Truth** - Repository pattern
3. ✅ **Reactive Programming** - StateFlow y Coroutines
4. ✅ **Dependency Injection manual** - Instancias únicas
5. ✅ **Composables reutilizables** - DRY principle
6. ✅ **Error Handling** - Try-catch con mensajes claros
7. ✅ **Loading States** - Feedback visual al usuario
8. ✅ **Null Safety** - Kotlin null safety features
9. ✅ **Material Design 3** - Últimas guías de diseño
10. ✅ **Animaciones suaves** - Mejor experiencia de usuario

## 🐛 Manejo de Errores

La aplicación maneja varios tipos de errores:

```kotlin
try {
    val response = repository.getPeople()
    _people.value = response.results
} catch (e: Exception) {
    _error.value = "Error al cargar personajes: ${e.message}"
} finally {
    _isLoading.value = false
}
```

**Errores manejados:**
- Sin conexión a internet
- Timeout de la API
- Respuestas inválidas
- Errores del servidor

## 📈 Futuras Mejoras

- [ ] Implementar base de datos local (Room)
- [ ] Agregar favoritos
- [ ] Modo offline
- [ ] Imágenes reales de personajes
- [ ] Soporte multiidioma
- [ ] Tests unitarios y de integración
- [ ] Dark/Light mode toggle
- [ ] Animación de opening crawl
- [ ] Compartir información en redes sociales
- [ ] Widget de pantalla de inicio




## 👨‍💻 Autor

**[José Stiven Rodas Beltrán]**
- GitHub: [Stiven1128](https://github.com/Stiven1128)
- Email: jose.rodas34265@ucaldas.edu.co

## 🙏 Agradecimientos

- [SWAPI](https://swapi.dev/) - The Star Wars API
- [Star Wars](https://www.starwars.com/) - Por el increíble universo
- [Android Developers](https://developer.android.com/) - Documentación
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI toolkit

---

⭐ **"Que la Fuerza te acompañe"** ⭐

---


## 📚 Recursos Adicionales

- [Documentación de Retrofit](https://square.github.io/retrofit/)
- [Guía de Jetpack Compose](https://developer.android.com/jetpack/compose/documentation)
- [SWAPI Documentation](https://swapi.dev/documentation)
- [Material Design 3](https://m3.material.io/)
