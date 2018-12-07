
plugins {
    kotlin("jvm")
    id("jps-compatible")
}

jvmTarget = "1.6"

dependencies {
    compile(project(":kotlin-script-runtime"))
    compile(project(":kotlin-stdlib"))
    compile(project(":kotlin-scripting-common"))
    compile(project(":kotlin-scripting-jvm"))
    compile(project(":kotlin-script-util"))
    compileOnly(project(":kotlin-reflect-api"))
    compileOnly(project(":compiler:cli"))
    compileOnly(intellijCoreDep())
    runtime(project(":kotlin-reflect"))
    runtime(projectRuntimeJar(":kotlin-compiler"))
    testCompile(projectTests(":compiler:tests-common"))
    testCompile(commonDep("junit"))
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

standardPublicJars()

dist()

ideaPlugin()

publish()

projectTest {
    workingDir = rootDir
}
