# AGENTS.md - MineColonies (FesterColonies)

## Project Context

This project is a custom fork and development branch (**`festercolonies-1.19.2`**) of **MineColonies**, an interactive city-building colony simulator mod for Minecraft Forge.

- **Repository Maintainer / Fork Owner:** FesterHead
- **Upstream Authors:** LDT Team (Let's Do Together)
- **Target Minecraft Version:** 1.19.2
- **Forge Target:** Forge 43.2.0 (FML range: `[38,)`, Forge range: `[41.1.0,)`)
- **Primary Language:** Java 17 (Amazon Corretto 17)
- **Build System:** Gradle 8.1.1 with ForgeGradle 6.0+ and OperaPublicaCreator scripts
- **Mod ID:** `minecolonies`
- **Key Companion Mods:** Structurize, BlockUI, Domum Ornamentum, Multi-Piston

---

## Architecture & Project Structure

The project uses a multi-source-set Forge mod architecture:

- **`src/api` (`api` source set):** Public interfaces and contract classes (`com.minecolonies.api`). Defines colony interfaces, citizen job types, building interfaces, and cross-mod compatibility bridges (`com.minecolonies.api.compatibility`).
- **`src/main` (`main` source set):** Core mod implementation (`com.minecolonies.core`). Houses citizen entities, AI pathfinding and tasks, colony managers, building logic, blueprint/schematic placement handlers, inventories, GUI screens, and network packets.
- **`src/datagen` (`datagen` source set):** Minecraft Forge data generators (`com.minecolonies.datagen`) for generating JSON recipes, loot tables, tags, blockstates, and models.
- **`libs/`:** Local dependencies folder. Used for legacy/unmirrored companion jars (such as `DynamicTrees-1.19.2-1.1.0-BETA10.jar`) to bypass obsolete or failing remote maven endpoints.

---

## Agent Guardrails & Engineering Rules

When generating, modifying, or refactoring code in this repository, strictly adhere to these rules:

### 1. Java & Toolchain Standards

- **Strict Java 17 Requirement:** All code must compile and run on **Java 17**. Never introduce Java 21+ syntax or features.
- **Gradle JVM Selection:** The Gradle daemon must run on Java 17 (`org.gradle.java.home` in `gradle.properties`). Gradle 8.1.1 will fail if run on Java 21 (`Unsupported class file major version 65`).
- **Build Verification:** Verify changes with:
  - `./gradlew compileJava` - compiles the `api` and `main` source sets.
  - `./gradlew jar` - generates the development/slim jar (`build/libs/minecolonies-*-slim.jar`).
  - `./gradlew shadowJar` - generates the full standalone mod jar (`build/libs/minecolonies-*.jar`).

### 2. Thread Safety & Server Ticking

- **World Access & Block Changes:** Never modify Minecraft world blocks, inventories, or entities off the main server thread. Use server tick handlers, colony task queues, or packet responses executed on the main server thread.
- **Citizen AI Ticking:** Citizen AI routines run every game tick (`EntityAICitizen` and worker AI subtasks). Avoid expensive calculations or blocking operations inside `tick()` methods; distribute expensive checks across multiple ticks.

### 3. API Contract Separation

- Preserve the boundary between `src/api` and `src/main`.
- Add new cross-mod or external integration points into `com.minecolonies.api` so other addons/mods can interact cleanly without depending on internal core implementation details.

### 4. Resource & Template Integrity

- **`mods.toml` Variable Expansion:** Properties expanded by Gradle's `processResources` task into `src/main/resources/META-INF/mods.toml` are injected as flat variables (e.g., `${structurize_version}`, `${minecraftVersion}`). **Do not prefix them with `${project...}`**, as `project` is not bound in the template expansion scope.
- **Localization:** When introducing new items, citizen dialogue, or UI elements, add translation keys to the relevant language files under `src/main/resources/assets/minecolonies/lang/`.

### 5. Documentation Maintenance

- Whenever code, build configuration, or mod behaviors are added, modified, or fixed:
  1. Add an entry under `## [Unreleased]` in `CHANGELOG.md` following the [Keep a Changelog](https://keepachangelog.com/) format.
  2. Document new or altered user-facing mechanics in relevant documentation files.
- Attribution and copyright for custom fork changes must credit **FesterHead**, while preserving original **LDT Team** headers and notices on base files.
