plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.openapi.generator") version "7.14.0"
    id("kotlin-kapt")
}

openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$rootDir/app/src/main/assets/DestiNumber Server API.yaml")
    outputDir.set("$buildDir/generated/openapi")
    apiPackage.set("by.alerus.destinumber.data.api")
    modelPackage.set("by.alerus.destinumber.data.model")
    validateSpec.set(false)
    skipValidateSpec.set(true)
    configOptions.set(
        mapOf(
            "library" to "jvm-okhttp4",
            "useCoroutines" to "true",
            "dateLibrary" to "java8"
        )
    )
}

android {
    namespace = "by.alerus.destinumber"
    compileSdk = 36

    defaultConfig {
        applicationId = "by.alerus.destinumber"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    sourceSets.getByName("main") {
        kotlin.srcDir("$buildDir/generated/openapi/src/main/kotlin")
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // API client
    implementation(libs.okhttp)
    implementation(libs.moshi.kotlin)
    implementation(libs.logging.interceptor)

    // DI
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    // Security
    implementation(libs.androidx.security.crypto)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)

    // Icons
    implementation("androidx.compose.material:material-icons-extended")
    
    // Markdown rendering
    implementation("com.github.jeziellago:compose-markdown:0.3.6")
}