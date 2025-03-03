package com.ladibells.leagueoflegends.ui.screen.champion_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ladibells.leagueoflegends.R
import com.ladibells.leagueoflegends.data.repository.ApiRepositoryImpl
import com.ladibells.leagueoflegends.domain.model.ChampionModel
import com.ladibells.leagueoflegends.ui.theme.LeagueOfLegendsTheme

@Composable
fun ChampionCard(
    champion: ChampionModel,
    modifier: Modifier = Modifier,
) {
    Row (
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ){
        AsyncImage(
            model = ApiRepositoryImpl.imageLoadingUrl + "${champion.id}_0.jpg",
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .weight(0.3f)
                .height(180.dp)
        )

        Column (
            modifier = Modifier
                .weight(0.7f)
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = champion.name ?: "Unknown",
                modifier = Modifier.padding(bottom = 5.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = champion.blurb ?: "",
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                lineHeight = 24.sp
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ChampionCardPreview() {
    LeagueOfLegendsTheme {
        ChampionCard(
            champion = ChampionModel(
                name = "Draven",
                title = "The Glorious Executioner"
            )
        )
    }
}