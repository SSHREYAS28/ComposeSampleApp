plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.mylibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(libs.androidx.compose.material.window)
    implementation(libs.androidx.compose.preview)
    implementation(libs.androidx.compose.tooling)
    implementation(libs.gson)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.androidx.compose.junit)
    testImplementation(libs.mockk)
    testImplementation (libs.org.jetbrains.kotlinx)

}