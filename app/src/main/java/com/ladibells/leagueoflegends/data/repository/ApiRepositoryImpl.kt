package com.ladibells.leagueoflegends.data.repository

import com.ladibells.leagueoflegends.domain.model.ChampionResponseModel
import com.ladibells.leagueoflegends.domain.repository.ApiRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient

class ApiRepositoryImpl(
    private val httpClient: HttpClient
): ApiRepository {

    companion object {
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/13.10.1/data/en_US/champion.json"
        const val BASE_URL_BY_NAME = "https://ddragon.leagueoflegends.com/cdn/14.23.1/data/en_US/"

        const val baseUrl = "https://ddragon.leagueoflegends.com/cdn/9.19.1/data/en_US/"
        const val imageSplashUrl = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
        const val imageLoadingUrl = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
        const val imageSquareUrl = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/"
        const val imagePassiveUrl = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/passive/"
        const val imageAbilityUrl = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/"
    }

    override suspend fun getAllChampions(): ApiResponse<ChampionResponseModel> =
        httpClient.getApiResponse("champion.json")


    override suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel> =
        httpClient.getApiResponse("champion/$name.json")

}