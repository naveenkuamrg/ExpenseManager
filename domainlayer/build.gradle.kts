plugins {
    kotlin("jvm")
    alias(libs.plugins.java.library)
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // This allows you to use @Inject in your pure Kotlin classes
    implementation("javax.inject:javax.inject:1")

    // Coroutines (optional, but likely needed for UseCases)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}