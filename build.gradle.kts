plugins {
    id("java")
}

group = "com.github.zdziszkee.elevatorsystem"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.github.zdziszkee.elevatorsystem.ElevatorSystem"
    }
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

}
tasks.test {
    useJUnitPlatform()
}