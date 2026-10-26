pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Expense Tracker"
include(":app")
include(":feature:home:data")
include(":core:ui")
include(":feature:transactions:data")
include(":feature:budget:data")
include(":feature:profile:presentation")
include(":feature:auth:login")
include(":feature:auth:signup")
include(":feature:budget:presentation")
include(":feature:budget:domain")
include(":feature:home:presentation")
include(":feature:home:domain")
include(":feature:transactions:presentation")
include(":feature:transactions:domain")
include(":core:database")
include(":feature:income:data")
include(":feature:income:presentation")
include(":feature:income:domain")
