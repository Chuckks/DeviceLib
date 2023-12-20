buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()

        maven { url = java.net.URI("https://jitpack.io") }
        //maven {  url = java.net.URI( "https://plugins.gradle.org/m2/")}
    }
}