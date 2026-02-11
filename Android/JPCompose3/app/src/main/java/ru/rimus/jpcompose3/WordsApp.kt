package ru.rimus.jpcompose3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun WordsApp(wordsViewModel: WordsViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable("main_screen") {
            MainScreen(
                wordsViewModel = wordsViewModel,
                onWordClick = { wordId ->
                    navController.navigate("detail_screen/$wordId")
                }
            )
        }

        composable(
            route = "detail_screen/{wordId}",
            arguments = listOf(navArgument("wordId") { type = NavType.IntType })
        ) { backStackEntry ->
            val wordId = backStackEntry.arguments?.getInt("wordId") ?: 0
            val word = wordsViewModel.getWordById(wordId)

            DetailScreen(
                word = word,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun MainScreen(
    wordsViewModel: WordsViewModel,
    onWordClick: (Int) -> Unit
) {
    val wordsList by wordsViewModel.wordsList.collectAsState()
    val selectedCount = wordsViewModel.getSelectedWordsCount()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Список слов") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                actions = {
                    // Индикатор выбранных элементов
                    Box(
                        modifier = Modifier.padding(end = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        if (selectedCount > 0) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "$selectedCount",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = wordsList,
                key = { item -> item.id } // Важно для сохранения состояния при скролле
            ) { wordItem ->
                WordCard(
                    wordItem = wordItem,
                    onCheckedChange = { wordsViewModel.toggleCheckbox(wordItem.id) },
                    onWordClick = { onWordClick(wordItem.id) }
                )
            }
        }
    }
}

@Composable
fun WordCard(
    wordItem: WordItem,
    onCheckedChange: (Boolean) -> Unit,
    onWordClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onWordClick() },
        elevation = 4.dp,
        backgroundColor = if (wordItem.isChecked)
            MaterialTheme.colors.primary.copy(alpha = 0.1f)
        else
            MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Чекбокс
            Checkbox(
                checked = wordItem.isChecked,
                onCheckedChange = { onCheckedChange(it) },
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Информация о слове
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = wordItem.word,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = wordItem.category,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.primary
                )
            }

            // Индикатор для перехода
            Text(
                text = "->",
                fontSize = 20.sp,
                color = Color.Gray
            )
        }
    }
}