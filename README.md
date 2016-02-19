# android-run-plugin

first execute

`gradle uploadArchives`

project build.gradle 

```
buildscript {
    repositories {
        maven {
            url '../android-run-plugin/repo'
        }
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.5.0'
        classpath 'com.github.sunsheng.android.plugin:android-run-plugin:1.0.0'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

```

main project build.gradle

`apply plugin: 'com.github.sunsheng.run'`
