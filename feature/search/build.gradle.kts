plugins {
    alias(libs.plugins.fetch.android.feature)
    alias(libs.plugins.fetch.android.library.compose)
}

android {
    namespace = "com.fetch.feature.search"
}