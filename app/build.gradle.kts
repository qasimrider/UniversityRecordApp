import com.android.build.api.variant.BuildConfigField

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
    id ("androidx.navigation.safeargs.kotlin")

}

android { namespace = "com.learning.universityrecordapp"

    buildTypes {
        debug {
            BuildConfigField("BASE_URL","http://www.google.com", "")
        }
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":dtos"))
    implementation(project(":list-university-feature"))
    implementation(project(":detail-university-feature"))
    implementation(libs.dagger.hilt)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    kapt(libs.dagger.hilt.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}