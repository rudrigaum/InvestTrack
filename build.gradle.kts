// build.gradle.kts (Project: InvestTrack)

// Declares all plugins used across the project.
// The `apply false` means they are declared here but NOT applied to the root —
// each module applies only what it needs.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}