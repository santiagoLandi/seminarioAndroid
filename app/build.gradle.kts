plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.parcelizeKotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsKotlinSerialization)
}
val versionMajor = 1
val versionMinor = 1
val versionPatch = 2
android {
    namespace = "ar.edu.unicen.seminario"
    compileSdk = 34

    defaultConfig {
        applicationId = "ar.edu.unicen.seminario"
        minSdk = 26
        targetSdk = 34
        versionCode = versionMajor * 100 + versionMinor * 10 + versionPatch
        versionName = "$versionMajor.$versionMinor.$versionPatch"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "THE_MOVIE_DB_API_KEY", "\"${project.findProperty("THE_MOVIE_DB_API_KEY")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true //le decimos q elimine el codigo q no utilizamos, hace q ocupe menos espacio
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")

        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        compose = true
    }
    // Especifica la versión del compilador de Compose aquí
   // composeOptions {
   //     kotlinCompilerExtensionVersion = "1.6.8" // Ajusta esta versión si es necesario
   // }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.activityKtx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.glide)
    implementation(libs.glide.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.jetbrains.kotlin.serialization)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}