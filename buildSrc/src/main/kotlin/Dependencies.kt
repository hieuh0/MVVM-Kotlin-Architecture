object Kotlin {
    const val standardLibrary = "1.5.0"
    const val coroutines = "1.5.0-RC"
}

object AndroidSdk {
    const val min = 23
    const val compile = 30
    const val target = compile
    const val buildToolsVersion = "30.0.3"
}

object AndroidClient {
    const val appId = "com.nta.mvvm_kotlin"
    const val versionCode = 1
    const val versionName = "1.0"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildPlugins {
    object Versions {
        const val buildToolsVersion = "4.2.0"
        const val gradleVersion = "6.7.1"
        const val hilt = "2.35.1"
        const val nav_version = "2.3.5"
        const val easylauncher_version = "1.3.1"
    }

    const val navigation_gradle_plugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.standardLibrary}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val androidHilt = "dagger.hilt.android.plugin"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val navigation_safe = "androidx.navigation.safeargs.kotlin"
    const val easylauncher = "com.akaita.android:easylauncher:${Versions.easylauncher_version}"
    const val easylauncherPlugin = "com.akaita.android.easylauncher"
}
object ScriptPlugins {
    const val infrastructure = "scripts.infrastructure"
    const val variants = "scripts.variants"
    const val quality = "scripts.quality"
    const val compilation = "scripts.compilation"
}

object Libraries{
    private object Versions {
        const val hilt = BuildPlugins.Versions.hilt
        const val appCompat = "1.2.0"
        const val constraintLayout = "2.0.1"
        const val recyclerView = "1.1.0"
        const val cardView = "1.0.0"
        const val material = "1.2.1"
        const val lifecycle = "2.3.1"
        const val lifecycleExtensions = "2.1.0"
        const val annotations = "1.1.0"
        const val ktx = "1.3.1"
        const val glide = "4.11.0"
        const val retrofit = "2.9.0"
        const val okHttpLoggingInterceptor = "4.9.0"
        const val nav_version = "2.3.5"
        const val stetho_version = "1.6.0"
        const val fragment_version = "1.3.3"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Kotlin.standardLibrary}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho_version}"
    const val stetho_okhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho_version}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"

}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.13.1"
        const val testRunner = "1.1.0"
        const val espressoCore = "3.2.0"
        const val espressoIntents = "3.1.0"
        const val testExtensions = "1.1.1"
        const val testRules = "1.1.0"
        const val hiltTesting = BuildPlugins.Versions.hilt
    }

    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtensions}"
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
