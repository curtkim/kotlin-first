import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.3")

    implementation("io.arrow-kt:arrow-core:1.1.2")
    //implementation("io.arrow-kt:arrow-syntax:1.1.2")
    implementation("io.arrow-kt:arrow-optics:1.1.2")
    implementation("io.arrow-kt:arrow-fx:0.12.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}