# Description

Briefly describe the purpose of this pull request, the problem it solves, or the feature it introduces.

Closes #<!-- issue number, if applicable -->

## Type of Change

- [ ] **Bug fix** (non-breaking change fixing an issue)
- [ ] **New feature** (non-breaking change adding functionality or colony mechanic)
- [ ] **Citizen AI / Pathfinding** (enhancement or fix to worker routines)
- [ ] **Performance optimization** (reducing server tick overhead, memory usage, or network sync)
- [ ] **Cross-mod compatibility** (integrations with companion or external mods)
- [ ] **Build / Toolchain / Documentation** (Gradle, datagen, configs, documentation)

## Subsystems Impacted

- [ ] Citizens & Jobs (AI routines, pathfinding, happiness, inventory)
- [ ] Colony & Buildings (colony management, permissions, modules, levels)
- [ ] Placement & Schematics (blueprints, scanning, placement handlers)
- [ ] Networking & GUI (BlockUI windows, packets, client rendering)
- [ ] Data Generators & Resources (recipes, tags, lang files, models)
- [ ] Build & Dependencies (Gradle scripts, `gradle.properties`, `mods.toml`)

## Testing & Verification

- [ ] Verified build succeeds locally with `./gradlew compileJava` and `./gradlew jar`.
- [ ] Tested in single-player world (creative / survival).
- [ ] Tested on dedicated server / multiplayer environment.
- [ ] Verified citizen ticking and AI routines run smoothly without tick stalls or pathfinding crashes.
- [ ] Tested edge cases (missing worker tools, blocked paths, colony borders, unloaded chunks).

## Checklist

- [ ] Code strictly complies with **Java 17** standards (no Java 21+ features).
- [ ] Preserved separation between `src/api` and `src/main`.
- [ ] All world block, entity, and inventory modifications are performed on the main server thread.
- [ ] Added or updated localization keys in `assets/minecolonies/lang/` if new text/dialogue was introduced.
- [ ] Added an entry under `## [Unreleased]` in `CHANGELOG.md` following [Keep a Changelog](https://keepachangelog.com/) format.
- [ ] Code follows project style guidelines and includes clear docstrings/comments where appropriate.
