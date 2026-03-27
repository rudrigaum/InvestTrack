package com.rodrigo.investtrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rodrigo.investtrack.core.ui.theme.InvestTrackTheme
import com.rodrigo.investtrack.feature.home.ui.navigation.HOME_ROUTE
import com.rodrigo.investtrack.feature.home.ui.navigation.homeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InvestTrackTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = HOME_ROUTE,
                    ) {
                        homeScreen(
                            onNavigateToDetail = { ticker ->
                                // Detail navigation will be implemented later
                            },
                        )
                    }
                }
            }
        }
    }
}
