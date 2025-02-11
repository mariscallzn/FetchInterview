plugins {
    alias(libs.plugins.fetch.android.feature)
    alias(libs.plugins.fetch.android.library.compose)
}

android {
    namespace = "com.fetch.feature.home"
}

dependencies {
    api(projects.feature.search)
    api(projects.feature.me)
}