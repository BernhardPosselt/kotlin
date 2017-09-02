
apply { plugin("kotlin") }

dependencies {
    compileOnly(ideaSdkDeps("openapi", "idea", "gson"))
    compileOnly(ideaPluginDeps("maven", "maven-server-api", plugin = "maven"))

    compile(project(":core:util.runtime"))
    compile(project(":compiler:frontend"))
    compile(project(":compiler:frontend.java"))
    compile(project(":compiler:util"))
    compile(project(":compiler:cli-common"))
    compile(project(":kotlin-build-common"))

    compile(project(":js:js.frontend"))

    compile(project(":idea"))
    compile(project(":idea:idea-jps-common"))

    testCompile(projectTests(":idea"))
    testCompile(project(":compiler.tests-common"))
    testCompile(project(":idea:idea-test-framework"))
    testCompileOnly(ideaSdkDeps("openapi", "idea", "gson"))
    testCompileOnly(ideaPluginDeps("maven", "maven-server-api", plugin = "maven"))

    testRuntime(ideaSdkDeps("*.jar"))
    testRuntime(ideaPluginDeps("resources_en", plugin = "junit"))
    testRuntime(ideaPluginDeps("jcommander", "resources_en", plugin = "testng"))
    testRuntime(ideaPluginDeps("resources_en", plugin = "properties"))
    testRuntime(ideaPluginDeps("*.jar", plugin = "gradle"))
    testRuntime(ideaPluginDeps("*.jar", plugin = "Groovy"))
    testRuntime(ideaPluginDeps("jacocoant", plugin = "coverage"))
    testRuntime(ideaPluginDeps("*.jar", plugin = "maven"))
    testRuntime(ideaPluginDeps("*.jar", plugin = "android"))
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

projectTest {
    workingDir = rootDir
}
