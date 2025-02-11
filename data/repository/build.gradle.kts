plugins {
    alias(libs.plugins.fetch.android.library)
    alias(libs.plugins.fetch.hilt)
}

android {
    namespace = "com.fetch.data.repository"
}

dependencies {
    api(projects.data.api)
    implementation(projects.data.retrofit)
    implementation(projects.data.room)
}

