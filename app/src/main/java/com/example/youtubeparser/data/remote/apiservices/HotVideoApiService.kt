package com.example.youtubeparser.data.remote.apiservices

import com.example.youtubeparser.data.models.HotVideo
import com.example.youtubeparser.data.models.VideoResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface HotVideoApiService {

    @GET("videos")
    suspend fun fetchPopularVideos(
        @Query("regionCode") regionCode: String,
        @Query("chart") chart: String,
        @Query("part") part: String,
        @Query("pageToken") nextPageToken: String
    ): VideoResponce<HotVideo>
}