package aiswarya.hopes.tcs_test.di

import aiswarya.hopes.tcs_test.data.local.AppDatabase
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,

    ) = Room.databaseBuilder(app, AppDatabase::class.java,"local_dbs")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideBookDao(db: AppDatabase) = db.bookDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope