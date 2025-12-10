package com.example.starwarsapp_proyecto_final.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.starwarsapp_proyecto_final.ui.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Pantalla de inicio
        composable("home") {
            HomeScreen(
                onNavigateToPeople = { navController.navigate("people") },
                onNavigateToFilms = { navController.navigate("films") },
                onNavigateToPlanets = { navController.navigate("planets") },
                onNavigateToStarships = { navController.navigate("starships") },
                onNavigateToVehicles = { navController.navigate("vehicles") }
            )
        }

        // Lista de personajes
        composable("people") {
            PeopleListScreen(
                onNavigateBack = { navController.popBackStack() },
                onPersonClick = { personId ->
                    navController.navigate("person/$personId")
                }
            )
        }

        // Detalle de personaje
        composable(
            route = "person/{personId}",
            arguments = listOf(navArgument("personId") { type = NavType.IntType })
        ) { backStackEntry ->
            val personId = backStackEntry.arguments?.getInt("personId") ?: 1
            PersonDetailScreen(
                personId = personId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Lista de películas
        composable("films") {
            FilmsListScreen(
                onNavigateBack = { navController.popBackStack() },
                onFilmClick = { filmId ->
                    navController.navigate("film/$filmId")
                }
            )
        }

        // Detalle de película
        composable(
            route = "film/{filmId}",
            arguments = listOf(navArgument("filmId") { type = NavType.IntType })
        ) { backStackEntry ->
            val filmId = backStackEntry.arguments?.getInt("filmId") ?: 1
            FilmDetailScreen(
                filmId = filmId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Lista de planetas
        composable("planets") {
            PlanetsListScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Lista de naves
        composable("starships") {
            StarshipsListScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Lista de vehículos
        composable("vehicles") {
            VehiclesListScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}