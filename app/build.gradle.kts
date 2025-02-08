plugins {
    alias(libs.plugins.fetch.android.application)
    alias(libs.plugins.fetch.android.application.compose)
}

android {
    namespace = "com.fetch.interview"

    defaultConfig {
        applicationId = "com.fetch.interview"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.core.uisystem)
    implementation(projects.feature.home)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}