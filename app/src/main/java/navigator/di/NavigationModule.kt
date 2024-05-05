package navigator.di

import com.learning.feature_university_detail.navigator.DetailNavigator
import com.learning.featureuniversitylist.navigator.ListNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import navigator.NavigatorImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Singleton
    @Provides
    fun provideListNavigator(navigatorImpl: NavigatorImpl): ListNavigator = navigatorImpl

    @Singleton
    @Provides
    fun provideDetailsNavigator(navigatorImpl: NavigatorImpl): DetailNavigator = navigatorImpl

    @Singleton
    @Provides
    fun provideNavigator(): NavigatorImpl = NavigatorImpl()
}
