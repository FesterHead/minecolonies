# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Changed

- Updated `gradle.properties`:
  - Configured `org.gradle.java.home=C:/Program Files/Amazon Corretto/jdk17.0.20_10` to ensure Gradle forks and runs builds strictly under Amazon Corretto JDK 17, preventing Java 21 bytecode parsing exceptions (`major version 65`) in Gradle 8.1.1.
- Updated `gradle/dependencies.gradle`:
  - Routed the `compileOnly` and `apiCompileOnly` dependencies for Dynamic Trees to local file `libs/DynamicTrees-1.19.2-1.1.0-BETA10.jar`, bypassing upstream LDTTeam JFrog Artifactory HTTP 409 Conflict errors when downloading legacy 1.19.2 artifacts.

### Fixed

- Fixed `src/main/resources/META-INF/mods.toml`:
  - Corrected Groovy template variable bindings during the `processResources` task by removing the extraneous `project.` prefix from `${project.jmapVersion}`, `${project.minecraftVersion}`, and `${project.dynamicTreesVersion}`.
