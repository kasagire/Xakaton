plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 35 // Укажите актуальную версию SDK
    namespace = "com.example.studenteventsapp"
    defaultConfig {
        applicationId = "com.example.studenteventsapp"
        minSdk = 27 // Минимальная поддерживаемая версия
        //noinspection EditedTargetSdkVersion
        targetSdk = 35 // Целевая версия SDK
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false // Включите, если используете ProGuard или R8
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // Опционально: если используете View Binding или Data Binding
    buildFeatures {
        viewBinding = true // Включите View Binding, если используете его
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6" // Use the latest version
    }

    kotlinOptions {
        jvmTarget = "17" // Ensure this matches the Kotlin version capabilities
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.21") // Укажите актуальную версию Kotlin
    implementation("androidx.appcompat:appcompat:1.7.0") // Библиотека поддержки
    implementation("androidx.core:core-ktx:1.15.0") // KTX для более удобного использования API

    // RecyclerView для списков
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Другие зависимости, которые могут понадобиться
    implementation("com.google.android.material:material:1.12.0") // Material Design Components

    // Если используете библиотеки для работы с сетью или базами данных, добавьте их здесь
    // Add Retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:2.11.0") // Retrofit core library
    implementation("com.squareup.retrofit2:converter-gson:2.11.0") // Gson converter for Retrofit

    implementation("androidx.compose.ui:ui:1.7.5") // UI components
    implementation("androidx.compose.material:material:1.7.5") // Material Design components
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5") // Preview support
    implementation("androidx.activity:activity-compose:1.9.3") // Activity support for Compose

    // Jetpack Compose dependencies
    implementation("androidx.compose.ui:ui:1.7.5") // Latest stable version
    implementation("androidx.compose.material:material:1.7.5") // Material Design components
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5") // Preview support
    implementation("androidx.activity:activity-compose:1.9.3") // Activity support for Compose

    // Jetpack Compose dependencies
    implementation("androidx.compose.ui:ui:1.7.5") // Latest stable version of UI components
    implementation("androidx.compose.material3:material3:1.3.1") // Material 3 components
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5") // Preview support
    implementation("androidx.activity:activity-compose:1.9.3") // Activity support for Compose
}

// Опционально: если у вас есть специфические настройки для тестирования
tasks.withType<Test> {
    useJUnitPlatform()
}