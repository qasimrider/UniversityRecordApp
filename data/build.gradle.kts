plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")

}

android { namespace = "com.learning.data" }

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.dagger.hilt)
    implementation(libs.material)
    implementation(libs.retrofit.coroutine.adapter)
    implementation(libs.flow.call.adapter)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.ok.http.interceptor)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.flow.call.adapter)
    implementation(libs.android.room.runtime)
    implementation(libs.android.roomktx)
    kapt(libs.androidx.room.compiler)
    implementation(project(":common"))
    implementation(project(":dtos"))
    kapt(libs.dagger.hilt.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}