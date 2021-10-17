package aiswarya.hopes.tcs_test.di

import aiswarya.hopes.tcs_test.data.local.AppDatabase
import aiswarya.hopes.tcs_test.data.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideBookRepository(appDatabase: AppDatabase) = BookRepository(appDatabase)
}