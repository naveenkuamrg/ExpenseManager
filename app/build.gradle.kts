plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // 1. ADD THIS LINE
    alias(libs.plugins.compose.compiler)

    alias(libs.plugins.hilt) // Apply Hilt plugin
    kotlin("kapt")
}

android {
    namespace = "com.example.expensemanager"
    compileSdk {
        // Note: 'release' is likely a custom extension you have, assuming it resolves to 35 or 36
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.expensemanager"
        minSdk = 26
        targetSdk = 36
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
    compileOptions {
        // Recommended: Update these to VERSION_17 to match your kotlin options below
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        // 2. DELETE OR COMMENT OUT THIS LINE
        // In Kotlin 2.0+, the compiler version is handled automatically by the plugin
        // kotlinCompilerExtensionVersion = "1.5.12"
    }

}

dependencies {
    implementation(project(":uilayer"))
    implementation(project(":domainlayer"))
    implementation(project(":datalayer"))
    implementation("com.google.android.material:material:1.11.0")

    // --- ADD THESE LINES ---
    // Import the Compose BOM
    implementation(platform(libs.androidx.compose.bom))


    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.9.0")
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

}