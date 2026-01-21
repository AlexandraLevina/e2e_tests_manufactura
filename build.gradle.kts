plugins {
    id("java")
}

group = "io.testomat"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java({
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }

})

dependencies {
    implementation("io.github.cdimascio:java-dotenv:5.2.2")
    testImplementation("com.codeborne:selenide:7.6.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}