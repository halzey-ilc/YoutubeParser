package com.example.youtubeparser.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("key", "AIzaSyBWU6Q0bqs5AFbWShm3mG9AWBOOxjnqZYo").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}