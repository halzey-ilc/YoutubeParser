package com.example.youtubeparser.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.youtubeparser.data.models.HotVideo
import com.example.youtubeparser.data.remote.apiservices.HotVideoApiService

import java.io.IOException

private const val STARTING_PAGE_TOKEN = ""

class HotVideoPagingSource(
    private val service: HotVideoApiService,
    private val regionCode: String,
    private val chart: String,
    private val part: String
) :
    PagingSource<String, HotVideo>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, HotVideo> {
        val page = params.key ?: STARTING_PAGE_TOKEN
        return try {
            val response = service.fetchPopularVideos(regionCode, chart, part, page)

            LoadResult.Page(
                data = response.items,
                prevKey = null,
                nextKey = response.nextPageToken
            )

        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, HotVideo>): String {
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey
        }
        return ""
    }
}
