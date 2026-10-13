# GitHub Copilot Instructions - MineColonies (FesterColonies)

This repository is a customized Minecraft Forge mod development branch (`festercolonies-1.19.2`) for **MineColonies 1.19.2**.

## Core Directives

1. **Target Environment:** Minecraft 1.19.2, Minecraft Forge 43.2.0, Java 17, Gradle 8.1.1.
2. **Project Author / Attribution:** Custom fork maintained by **FesterHead**. Base mod authored by **LDT Team**.
3. **Java Version Constraint:**
   - Always target **Java 17** compatibility.
   - Do not use Java 21+ APIs or syntax.
   - Gradle builds require JDK 17 configured in `gradle.properties` (`org.gradle.java.home`).
4. **Source Set Architecture:**
   - **`src/api`:** Public API contracts, colony capabilities, interfaces, and compatibility abstractions (`com.minecolonies.api`). Keep API contracts clean and stable.
   - **`src/main`:** Core mod implementation (`com.minecolonies.core`) including citizen entities, job AI, buildings, placement handlers, and network packets.
   - **`src/datagen`:** Data generation classes (`com.minecolonies.datagen`) for generating recipes, loot tables, and tags.
5. **Dependency & Resource Conventions:**
   - **Local Jars in `libs/`:** Companion or optional mods that are not reachable via active remote mavens (e.g. `DynamicTrees-1.19.2-1.1.0-BETA10.jar`) are resolved locally through the `libs/` directory.
   - **`mods.toml` Placeholders:** Use `${variableName}` directly (e.g., `${structurize_version}`, `${minecraftVersion}`). Never use `${project.variableName}` in `mods.toml`, as `project` is not bound in Groovy template expansion.
   - **Thread Safety:** All world, entity, and block modifications must execute on the main server thread.
6. **Documentation & Changelog:**
   - Keep `CHANGELOG.md` updated under `## [Unreleased]` following the [Keep a Changelog](https://keepachangelog.com/) format.
   - Maintain accurate descriptions and comments on all new classes and methods.
