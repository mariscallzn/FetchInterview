plugins {
    alias(libs.plugins.fetch.jvm.library)
    alias(libs.plugins.fetch.hilt)
}

dependencies {
    api(projects.data.api)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
}