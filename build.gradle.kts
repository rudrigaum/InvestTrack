// build.gradle.kts (Project: InvestTrack)

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.kover)
    alias(libs.plugins.sonarqube)
}

// --- Detekt ---
detekt {
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
    allRules = false
    source.setFrom(files("$rootDir/app/src"))
}

// --- ktlint ---
subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set("1.3.1")
        android.set(true)
        outputToConsole.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

// --- Kover ---
kover {
    merge {
        allProjects()
    }
}

sonar {
    properties {
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.organization", "Rodrigo Cerqueira")
        property("sonar.projectKey", "rudrigaum")
        property("sonar.projectName", "InvestTrack")
        property("sonar.sources", "app/src/main")
        property("sonar.tests", "app/src/test,app/src/androidTest")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/kover/report.xml")
        property("sonar.exclusions", "**/R.class,**/R$*.class,**/BuildConfig.*,**/generated/**")
    }
}
