package com.example.myblo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api
    val posts: MutableState<List<Post>> = mutableStateOf(emptyList())
    private val _postsFlow: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    val postsFlow: Flow<List<Post>> get() = _postsFlow

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getPosts()
                if (response.isNotEmpty()) {
                    posts.value = response
                    _postsFlow.value = response
                }
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}
