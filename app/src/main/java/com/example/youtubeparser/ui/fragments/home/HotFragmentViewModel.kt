package com.example.youtubeparser.ui.fragments.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.youtubeparser.base.BaseViewModel
import com.example.youtubeparser.data.repositories.VideoHotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotFragmentViewModel @Inject constructor(private val repository: VideoHotRepository) :
    BaseViewModel() {

    fun fetchVideosPopular(regionCode: String, chart: String, part: String) =
        repository.fetchVideosPopular(regionCode, chart, part).cachedIn(viewModelScope)
}