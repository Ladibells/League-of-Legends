package com.ladibells.leagueoflegends.ui.screen.champion_details

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ladibells.leagueoflegends.data.repository.ApiRepositoryImpl
import com.ladibells.leagueoflegends.domain.model.ChampionModel

@Composable
fun ChampionHeader(
    modifier: Modifier = Modifier,
    champion: ChampionModel
) {
    ListItem(modifier = modifier,
        headlineContent = {
            Text(
                text = champion.name ?: "Unknown",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
                          },
        supportingContent = { Text(text = champion.tags.firstOrNull() ?: "Unknown") },
        leadingContent = {
            AsyncImage(
                model = ApiRepositoryImpl.imageSquareUrl + "${champion.name}.png",
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        },
        trailingContent = {
            Text(
                text = champion.title ?: "Unknown",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun ChampionHeaderPreview() {
    ChampionHeader(champion = ChampionModel())
}