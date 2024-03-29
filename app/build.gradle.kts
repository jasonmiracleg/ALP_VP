plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.alp_vp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.alp_vp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //noinspection GradleDependency
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    //noinspection GradleDependency
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended") // Add Material Icon
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-compose:2.7.4") // add navigation library
    //noinspection GradleDependency
    implementation("androidx.compose.material3:material3:1.2.0-alpha02")
    //noinspection GradleDependency
    implementation("androidx.compose.material:material:1.0.0-beta02")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // View Model
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("com.google.accompanist:accompanist-permissions:0.30.1")
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation("com.github.skydoves:colorpicker-compose:1.0.7") // Color Picker
    implementation("io.coil-kt:coil-compose:2.4.0") // library compose that use synchronize
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // add library retrofit converter gson
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1") // add library to recognize json
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0") // add library to convert the json
    implementation("com.squareup.okhttp3:okhttp:4.11.0") // add library REST function
    implementation("androidx.datastore:datastore-preferences:1.0.0") // store token
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // add library retrofit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}