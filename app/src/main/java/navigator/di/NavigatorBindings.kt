/*
package com.turk.universityapp.di

import com.turk.universityapp.nav.Navigator
import com.turk.universitydetails.nav.UniversityDetailsNav
import com.turk.universitylisting.nav.UniversityListNav
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorBindings {

    @Provides
    @UniversityListNavQualifier
     fun bindUniversityListNav(
        @UniversityListNavQualifier navigator: Navigator): UniversityListNav

    @Provides
    @UniversityDetailNavQualifier
     fun bindUniversityDetailNavQualifier(
        @UniversityDetailNavQualifier navigator: Navigator): UniversityDetailsNav

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UniversityListNavQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UniversityDetailNavQualifier
*/
