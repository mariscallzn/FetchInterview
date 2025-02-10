plugins {
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.fetch.android.test)
}

android {
    namespace = "com.fetch.benchmarks"
    targetProjectPath = ":app"

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        experimentalProperties["android.experimental.self-instrumenting"] = true
    }
}

dependencies {
    implementation(libs.androidx.benchmark.macro)
    implementation(libs.androidx.test.core)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.junit)
    implementation(libs.androidx.test.rules)
    implementation(libs.androidx.test.runner)
    implementation(libs.androidx.test.uiautomator)
}
