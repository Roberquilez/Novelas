// app/build.gradle.kts
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.novelmanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.novelmanager"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0" // Actualiza a la última versión disponible
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.compose.ui:ui:1.5.0") // Actualiza a la última versión disponible
    implementation("androidx.compose.material3:material3:1.0.1") // Actualiza a la última versión disponible
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0") // Actualiza a la última versión disponible
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation("androidx.room:room-runtime:2.4.3")
    implementation(libs.androidx.foundation.android)
    kapt("androidx.room:room-compiler:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.0") // Actualiza a la última versión disponible
    implementation("androidx.compose.foundation:foundation:1.5.0") // Actualiza a la última versión disponible
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0") // Actualiza a la última versión disponible
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0") // Actualiza a la última versión disponible
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0") // Actualiza a la última versión disponible
}