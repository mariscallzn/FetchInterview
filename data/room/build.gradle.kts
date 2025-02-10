plugins {
    alias(libs.plugins.fetch.android.library)
    alias(libs.plugins.fetch.android.room)
    alias(libs.plugins.fetch.hilt)
}

android {
    namespace = "com.fetch.data.room"
}

dependencies {
    api(projects.data.api)
}