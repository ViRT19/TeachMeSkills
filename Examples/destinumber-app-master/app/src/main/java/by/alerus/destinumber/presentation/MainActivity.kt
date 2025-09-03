package by.alerus.destinumber.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.alerus.destinumber.R
import by.alerus.destinumber.data.network.TokenStorage
import by.alerus.destinumber.presentation.features.guess_card_screen.GuessCardScreen
import by.alerus.destinumber.presentation.features.help_screen.HelpScreen
import by.alerus.destinumber.presentation.features.history_screen.HistoryScreen
import by.alerus.destinumber.presentation.features.login_screen.LoginScreen
import by.alerus.destinumber.presentation.features.profile_screen.ProfileScreen
import by.alerus.destinumber.presentation.features.registration_screen.RegistrationScreen
import by.alerus.destinumber.presentation.theme.DestinumberTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val tokenStorage: TokenStorage by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startDestination = if (tokenStorage.getAccessToken() != null) "guess" else "login"

        enableEdgeToEdge()
        setContent {
            DestinumberTheme(
                darkTheme = true
            ) {
                val navController = rememberNavController()
                AppScaffold(
                    navController = navController,
                    onLogout = {
                        tokenStorage.clearTokens()
                        navController.navigate("login") {
                            popUpTo(0)
                        }
                    }
                ) {
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(it),
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppScaffold(
    navController: NavHostController,
    onLogout: () -> Unit,
    content: @Composable (innerPadding: androidx.compose.foundation.layout.PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = androidx.compose.material3.DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    if (currentRoute == "login" || currentRoute == "registration") {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {}) { innerPadding ->
            content(innerPadding)
        }
    } else {
        ModalNavigationDrawer(
            drawerContent = {
                androidx.compose.material3.ModalDrawerSheet {
                    Row(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(stringResource(R.string.menu_header), fontWeight = FontWeight.Bold)
                    }
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.menu_guess)) },
                        selected = currentRoute == "guess",
                        icon = { Icon(Icons.Filled.Star, contentDescription = null) },
                        onClick = {
                            scope.launch { drawerState.close() }
                            if (currentRoute != "guess") navController.navigate("guess")
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.menu_profile)) },
                        selected = currentRoute == "profile",
                        icon = { Icon(Icons.Filled.Person, contentDescription = null) },
                        onClick = {
                            scope.launch { drawerState.close() }
                            if (currentRoute != "profile") navController.navigate("profile")
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.menu_history)) },
                        selected = currentRoute == "history",
                        icon = { Icon(Icons.Filled.History, contentDescription = null) },
                        onClick = {
                            scope.launch { drawerState.close() }
                            if (currentRoute != "history") navController.navigate("history")
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.menu_help)) },
                        selected = currentRoute == "help",
                        icon = { Icon(Icons.Filled.Help, contentDescription = null) },
                        onClick = {
                            scope.launch { drawerState.close() }
                            if (currentRoute != "help") navController.navigate("help")
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.menu_logout)) },
                        selected = false,
                        icon = { Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null) },
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                onLogout()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                                    TopAppBar(
                    title = { 
                        Text(
                            when (currentRoute) {
                                "help" -> stringResource(R.string.help_title)
                                else -> stringResource(R.string.app_name)
                            }
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
                }
            ) { innerPadding ->
                content(innerPadding)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = "guess") {
            GuessCardScreen()
        }
        composable(route = "login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("guess")
                },
                onRegisterClick = {
                    navController.navigate("registration")
                }
            )
        }
        composable(route = "registration") {
            RegistrationScreen(
                onRegisterSuccess = {
                    navController.navigate("guess")
                },
                onBackToLogin = {
                    navController.navigate("login")
                }
            )
        }
        composable(route = "profile") {
            ProfileScreen()
        }
        composable(route = "history") {
            HistoryScreen()
        }
        composable(route = "help") {
            HelpScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppNavigationPreview() {
    DestinumberTheme(
        darkTheme = true
    ) {
        val navController = rememberNavController()
        AppScaffold(navController = navController, onLogout = {}) { innerPadding ->
            AppNavigation(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                startDestination = "login"
            )
        }
    }
}
