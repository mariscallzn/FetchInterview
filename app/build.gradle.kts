plugins {
    alias(libs.plugins.fetch.android.application)
    alias(libs.plugins.fetch.android.application.compose)
    alias(libs.plugins.fetch.hilt)
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
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(projects.data.retrofit)

    implementation(projects.core.uisystem)

    implementation(projects.feature.home)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}