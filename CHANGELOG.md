# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- Added expanded default citizen names from custom datapack into `src/main/resources/data/minecolonies/citizennames/default.json` (expanded name pool from 24 KB to 120 KB).
- Added additional building blocks and slabs (planks, wooden slabs, stone, cobblestone, andesite, granite, diorite, blackstone, deepslate, cobbled deepslate) to the `#minecolonies:pathblocks` tag in `src/datagen/generated/minecolonies/data/minecolonies/tags/blocks/pathblocks.json`.
- Added `femaleOnlyCitizens` server configuration toggle in `ServerConfiguration.java` (`femaleonlycitizens`, defaults to `true`):
  - Forces initial Town Hall citizen spawns and Tavern visitors to be female only, generating female names, biped models, textures, and voices.
  - Special custom visitors in `data/minecolonies/visitors/` remain exempt and retain their author-defined genders and skins.
- Added `enableReproduction` server configuration toggle in `ServerConfiguration.java` (`enablereproduction`, defaults to `false`):
  - Toggles whether citizens in houses can reproduce and spawn children.

### Changed

- Migrated custom University research configurations across all branches (`civilian`, `combat`, `technology`) from datapack into `src/datagen/generated/minecolonies/data/minecolonies/researches/`:
  - Streamlined research costs, replacing individual specific flower requirements with the generic `#minecraft:small_flowers` tag (`minecolonies:item_tag`), allowing any small flower to fulfill research requirements.
  - Merged multi-item flower requirements within individual researches into combined tag counts.
  - Added localization key `com.minecolonies.coremod.research.tags.minecraft:small_flowers` ("Small Flowers") to `default.json` and `en_us.json`.
  - Adjusted research effects in `researches/effects/` (`blockbreakspeedmultiplier`, `blockplacespeedmultiplier`, and `farmingmultiplier`) to begin at baseline 1.0x instead of early penalty debuffs.
  - Updated prerequisite tree and levels for `rainbowheaven` and `honeypot`.
- Disabled abandoned empty colony generation in Overworld and Nether structure sets (`src/main/resources/data/minecolonies/worldgen/structure_set/empty_colony.json` and `empty_nether_colony.json`).
- Updated `gradle.properties`:
  - Configured `org.gradle.java.home=C:/Program Files/Amazon Corretto/jdk17.0.20_12` to ensure Gradle forks and runs builds strictly under Amazon Corretto JDK 17, preventing Java 21 bytecode parsing exceptions (`major version 65`) in Gradle 8.1.1.
- Updated `gradle/dependencies.gradle`:
  - Routed the `compileOnly` and `apiCompileOnly` dependencies for Dynamic Trees to local file `libs/DynamicTrees-1.19.2-1.1.0-BETA10.jar`, bypassing upstream LDTTeam JFrog Artifactory HTTP 409 Conflict errors when downloading legacy 1.19.2 artifacts.
- Updated `README.md`:
  - Fixed markdownlint errors (heading hierarchy, list indentation, image alt texts, bare URLs, and duplicate headers).
  - Modernized developer documentation to reflect Java 17 requirements and Gradle Wrapper usage for 1.19.2 development.
- Added `.markdownlint.json` and `.markdownlintignore` matching project standards.

### Fixed

- Fixed `src/main/resources/META-INF/mods.toml`:
  - Corrected Groovy template variable bindings during the `processResources` task by removing the extraneous `project.` prefix from `${project.jmapVersion}`, `${project.minecraftVersion}`, and `${project.dynamicTreesVersion}`.
