plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.composesampleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.composesampleapp"
        minSdk = 26
        targetSdk = 34
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

    buildFeatures {
        viewBinding = true
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(libs.androidx.fragment.ktx)
    api(libs.androidx.navigation)
    api(libs.androidx.navigation.ktx)
    api(libs.hilt.navigation.fragment)
    api(libs.hilt.navigation.compose)
    api(libs.hilt.android)
    api(libs.gson)

    implementation(libs.filament)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.ktx)
    implementation(libs.androidx.lifecycle.compose)
    implementation(libs.androidx.compose.vm)
    implementation(libs.androidx.compose.nav)
    implementation(libs.systemuicontroller)
    implementation(libs.androidx.compose.material)
    implementation(libs.material)
    implementation(libs.androidx.compose.material.window)
    implementation(libs.androidx.compose.preview)
    implementation(libs.androidx.compose.tooling)
    implementation(libs.gson)
    implementation(project(":mylibrary"))
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.androidx.compose.junit)
    testImplementation(libs.mockk)
    testImplementation (libs.org.jetbrains.kotlinx)

}