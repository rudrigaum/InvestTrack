package com.rodrigo.investtrack.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class AuthInterceptor @Inject constructor(
    @Named("brapi_token") private val token: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val authenticatedUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter(QUERY_PARAM_TOKEN, token)
            .build()

        val authenticatedRequest = originalRequest
            .newBuilder()
            .url(authenticatedUrl)
            .build()

        return chain.proceed(authenticatedRequest)
    }

    companion object {
        private const val QUERY_PARAM_TOKEN = "token"
    }
}
