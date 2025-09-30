package com.example.flowerinpot.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flowerinpot.R
import com.example.flowerinpot.ui.viewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 34.dp, start = 34.dp, end = 42.dp)
    ) {
        var searchText by remember { mutableStateOf("") }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(
                    text = "Welcome, ",
                )
                Text(
                    text = "Trisha",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                //horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_shopping_bag),
                        contentDescription = ""
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_shopping_cart),
                        contentDescription = ""
                    )
                }
            }
        }

        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("indoor plants") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(20.dp)),
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search),
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.Gray,
                unfocusedContainerColor = Color.LightGray,
                unfocusedIndicatorColor = Color.LightGray
            )
        )

        Text(
            text = "Category",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(viewModel.loadCategory().value) { category ->
                Text(
                    text = category.title
                )

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular products",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "view all",
                modifier = Modifier
                    .clickable(
                        onClick = {}
                    ),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
        }
    }
}
