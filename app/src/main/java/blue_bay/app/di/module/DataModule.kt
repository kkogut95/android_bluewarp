package blue_bay.app.di.module

import dagger.Binds
import dagger.Module
import blue_bay.app.data.repository.AppRepository
import blue_bay.app.data.repository.AppRepositoryImpl
import blue_bay.app.data.repository.UserRepository
import blue_bay.app.data.repository.UserRepositoryImpl

@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

    @Binds
    internal abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}