package com.fetch.benchmarks

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FetchDataFromNetworkBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun fetchDataFromNetwork() = benchmarkRule.measureRepeated(
        packageName = "com.fetch.interview",
        metrics = listOf(FrameTimingMetric()),
        compilationMode = CompilationMode.Full(),
        iterations = 10,
        startupMode = StartupMode.WARM,
        setupBlock = {
            pressHome()
        },
    ) {
        startActivityAndWait()
        with(device) {
            //30k ms is the common time out for network calls.
            wait(Until.gone(By.res("search:progressIndicator")), 30_000)
        }
    }
}