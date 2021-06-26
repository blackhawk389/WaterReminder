// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
//    val kotlinVersion by System.getProperties()

    repositories {
        jcenter()
        google()

    }
    dependencies {
        classpath( "com.android.tools.build:gradle:4.1.3")
        classpath( "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0-RC")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://jitpack.io") }
        google()

    }

    extra["compileSdk"] = 30
}
