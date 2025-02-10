plugins {
    alias(libs.plugins.fetch.jvm.library)
    alias(libs.plugins.fetch.hilt)
}

dependencies {
    api(projects.data.api)
}

