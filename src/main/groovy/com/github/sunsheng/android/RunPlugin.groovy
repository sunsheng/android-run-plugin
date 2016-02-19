package com.github.sunsheng.android


import org.gradle.api.*


class RunPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.android.applicationVariants.all { variant ->
            variant.outputs.each { output ->
                def oldFile = output.outputFile
                output.outputFile = new File(oldFile.parent, oldFile.name.replace(".apk","-${variant.versionName}.apk"))

                if (variant.install) {
                    project.tasks.create(name: "run${variant.name.capitalize()}", dependsOn: variant.install) {
                        description "Installs the ${variant.description} and run the main launch activity"
                        doFirst {
                            project.exec {
                                executable 'adb'
                                args = [
                                    'shell',
                                    'am',
                                    'start',
                                    '-n',
                                    "${variant.applicationId}/.MainActivity"
                                ]
                            }
                        }   
                    }
                }
            }
        }    
    }
}