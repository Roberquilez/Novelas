package com.example.novelmanager

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.novelmanager.ui.theme.NovelManagerTheme

class MainActivity : ComponentActivity() {
    private val novelViewModel: NovelViewModel by viewModels()

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovelManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        novelViewModel = novelViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(novelViewModel: NovelViewModel, modifier: Modifier = Modifier) {
    val novels = novelViewModel.getAllNovels().observeAsState(emptyList())
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(novels.value) { novel ->
                NovelItem(novel, novelViewModel)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Button(
            onClick = {
                val newNovel = Novel(title = "Nueva Novela", author = "Autor Desconocido", synopsis = "", year = 2023)
                novelViewModel.insert(newNovel)
                Toast.makeText(context, "Novela agregada", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Agregar Nueva Novela")
        }
    }
}

@Composable
fun NovelItem(novel: Novel, novelViewModel: NovelViewModel) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = novel.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = novel.author, style = MaterialTheme.typography.bodyMedium)
        }
        Row {
            Button(onClick = {
                // Mostrar detalles de la novela
                Toast.makeText(context, "Detalles de: ${novel.title}", Toast.LENGTH_SHORT).show()
            }) {
                Text("Detalles")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                novelViewModel.delete(novel)
                Toast.makeText(context, "Novela eliminada", Toast.LENGTH_SHORT).show()
            }) {
                Text("Eliminar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val updatedNovel = novel.copy(isFavorite = !novel.isFavorite)
                novelViewModel.update(updatedNovel)
                Toast.makeText(context, if (updatedNovel.isFavorite) "Marcada como favorita" else "Desmarcada como favorita", Toast.LENGTH_SHORT).show()
            }) {
                Text(if (novel.isFavorite) "Desmarcar" else "Marcar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    NovelManagerTheme {
        MainScreen(novelViewModel = NovelViewModel(Application()))
    }
}

@Preview(showBackground = true)
@Composable
fun NovelItemPreview() {
    NovelManagerTheme {
        NovelItem(
            novel = Novel(title = "Ejemplo de Novela", author = "Autor Ejemplo", synopsis = "", year = 2023, isFavorite = false),
            novelViewModel = NovelViewModel(Application())
        )
    }
}