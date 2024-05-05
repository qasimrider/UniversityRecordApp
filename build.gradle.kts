// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.hilt) apply false
}
buildscript {
//    repositories {
//        google()
//    }
//    repositories {
//        google()
//    }
    dependencies {
//        classpath(libs.plugins.navsafeargs)
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")
//        classpath("androidx.navigation:navigation-safe-args-gradle-2.3.0")

//        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0")

    }
}
allprojects {
    repositories {
//        google()
//        mavenCentral()
//        maven(url = "https://maven.google.com/")
    }

}

apply("config.gradle")
