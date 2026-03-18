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
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "InvestTrack"

// Core modules
 include(":app")

 include(":core:network")
 include(":core:database")
 include(":core:ui")

 //Feature modules
 include(":feature:home")
 include(":feature:search")
 include(":feature:detail")
 include(":feature:watchlist")
 include(":feature:exchange")
