// settings.gradle.kts

pluginManagement {
    repositories {
        google {
            content {
                // Only load Android-related artifacts from Google
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // Prevents modules from declaring their own repositories —
    // all dependencies must come from here. Enforces consistency.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "InvestTrack"

// Core modules
include(":app")

// We will uncomment these as we create each module throughout the project:
// include(":core:network")
// include(":core:database")
// include(":core:ui")

// Feature modules
// include(":feature:home")
// include(":feature:search")
// include(":feature:detail")
// include(":feature:watchlist")
// include(":feature:exchange")
