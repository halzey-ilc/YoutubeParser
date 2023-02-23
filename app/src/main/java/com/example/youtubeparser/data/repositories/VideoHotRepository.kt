package com.example.youtubeparser.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtubeparser.base.BaseRepository
import com.example.youtubeparser.data.pagingsource.HotVideoPagingSource
import com.example.youtubeparser.data.remote.apiservices.HotVideoApiService
import javax.inject.Inject

class VideoHotRepository @Inject constructor(private val service: HotVideoApiService) :
    BaseRepository() {

    fun fetchVideosPopular(regionCode: String, chart: String, part: String) =
        Pager(PagingConfig(pageSize = 10, enablePlaceholders = false)) {
           HotVideoPagingSource (service = service, regionCode, chart, part)
        }.liveData
}