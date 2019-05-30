package app.bluebay.di.module

import dagger.Binds
import dagger.Module
import app.bluebay.data.repository.AppRepository
import app.bluebay.data.repository.AppRepositoryImpl
import app.bluebay.data.repository.UserRepository
import app.bluebay.data.repository.UserRepositoryImpl

@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

    @Binds
    internal abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}