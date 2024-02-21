package com.example.myblo

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow

@Composable
fun PostList(viewModel: MainViewModel) {
    val postsFlow: Flow<List<Post>> = viewModel.postsFlow
    val posts by postsFlow.collectAsState(initial = emptyList())

    LazyColumn {
        items(posts) { post ->
            Text(text = post.toString())
        }
    }
}
