plugins {
    alias(libs.plugins.fetch.android.feature)
    alias(libs.plugins.fetch.android.library.compose)
}

android {
    namespace = "com.fetch.feature.me"
}

dependencies {
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}