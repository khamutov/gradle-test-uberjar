# Uber jar for tests with Gradle

1. Add ShadowJar plugin

    ```gradle
    id 'com.github.johnrengelman.shadow' version '4.0.3'
    ```

2. Add task with type ShadowJar for build uber-jar

    ```gradle
    import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
    task testJar(type: ShadowJar) {
        manifest {
            attributes 'Main-Class': 'ru.butik.autotest.Main'
        }
        baseName = project.name + '-test'
        from sourceSets.test.output
        configurations = [project.configurations.testRuntime]
    }
    ```
    
    it include all sources and test classes and deps

3. run build
    ```bash
    𝝺 ./gradlew testJar
    ```

4. run tests on binary test build
    ```bash
    𝝺 java -jar build/libs/test-jar-test.jar
    Fast test
    Slow test
    
    ===============================================
    My Test Suite
    Total tests run: 2, Failures: 0, Skips: 0
    ===============================================
    
    ```

