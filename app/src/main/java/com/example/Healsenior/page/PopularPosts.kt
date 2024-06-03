package com.example.Healsenior.page

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.Healsenior.data.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularPosts(navController: NavHostController, posts: List<Post>) {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(posts.sortedByDescending { it.like + it.comments + it.view }) { post ->
                PostCard(post) {
                    navController.navigate("postDetail/${post.title}")
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
