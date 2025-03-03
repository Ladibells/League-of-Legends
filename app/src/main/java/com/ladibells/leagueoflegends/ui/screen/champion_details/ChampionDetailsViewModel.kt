package com.ladibells.leagueoflegends.ui.screen.champion_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.ladibells.leagueoflegends.domain.model.ChampionModel
import com.ladibells.leagueoflegends.domain.repository.ApiRepository
import com.ladibells.leagueoflegends.ui.util.ChampionDetails
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var champion = mutableStateOf<ChampionModel?>(null)

    init {

        val args = savedStateHandle.toRoute<ChampionDetails>()

        viewModelScope.launch {
            apiRepository.getChampionByName(args.name)
                .onSuccess {
                    champion.value = data.champion.values.firstOrNull()
                }
        }
    }
}