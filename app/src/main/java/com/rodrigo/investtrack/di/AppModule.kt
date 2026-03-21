// app/src/main/java/com/rodrigo/investtrack/di/AppModule.kt

package com.rodrigo.investtrack.di

import com.rodrigo.investtrack.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Named("brapi_token")
    fun provideBrApiToken(): String = BuildConfig.BRAPI_TOKEN
}
