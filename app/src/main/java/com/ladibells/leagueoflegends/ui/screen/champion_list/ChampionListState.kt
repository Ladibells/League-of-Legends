package com.ladibells.leagueoflegends.ui.screen.champion_list

import com.ladibells.leagueoflegends.domain.model.ChampionModel

data class ChampionListState (
    val searchText: String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList(),
)