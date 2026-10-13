# MineColonies

[![CLA assistant](https://cla-assistant.io/readme/badge/ldtteam/minecolonies)](https://cla-assistant.io/ldtteam/minecolonies)
[![Build Status](https://buildsystem.ldtteam.com/app/rest/builds/buildType:LetSDevTogether_Minecolonies_Alpha_Release/statusIcon)](http://buildsystem.ldtteam.com/)
[![Crowdin](https://badges.crowdin.net/minecolonies/localized.svg)](https://crowdin.com/project/minecolonies)

![MineColonies Logo](minecolonies_logo.png)

MineColonies is an interactive building mod that allows you to create a thriving town within Minecraft. It lets your leadership skills soar by providing you with everything you need to build your kingdom. MineColonies gives you the flexibility to create a colony as unique as every player. With so many options, you'll create a different colony every time, adapt it to any biome, build inside a mountain, on top of one, under the ocean, or in the sky.

The limit is your imagination!

MineColonies features NPC workers such as Builders, Farmers, Fishers, Foresters, Guards, Miners, Smelters, Bakers, Cooks, Couriers, five types of animal herders, Composters, and many more, with even more being developed and added as the mod grows.

It also includes specialized buildings such as the Warehouse, House, Town Hall, Barracks, Library, University, and even the School.

## Official Links

* **Website:** <https://www.minecolonies.com/>
* **CurseForge:** <https://www.curseforge.com/minecraft/mc-mods/minecolonies/files/all>
* **Discord Community:** <https://discord.minecolonies.com>

## For Users

### Creating an Issue

Does MineColonies crash? Have a suggestion? Found a bug? Create an issue:

1. Make sure your issue has not already been answered or fixed. Also think about whether your issue is a valid one before submitting it.
2. Go to the [MineColonies Issues page](https://github.com/ldtteam/minecolonies/issues).
3. Click `New Issue`.
4. Choose the appropriate issue template.
5. Fill in the form completely. Don't leave anything out!
6. Click `Submit New Issue` and wait for a response!

## For Developers

### Adding MineColonies as a Dependency

In Forge, add the following to your `build.gradle`:

```groovy
repositories {
    maven { url 'https://ldtteam.jfrog.io/ldtteam/modding' }
}

dependencies {
    implementation fg.deobf("com.ldtteam:minecolonies:${minecolonies_version}")
    implementation fg.deobf("com.ldtteam:structurize:${structurize_version}")
    implementation fg.deobf("com.ldtteam:multi-piston:${multipiston_version}")
    implementation fg.deobf("com.ldtteam:domum_ornamentum:${domumornamentum_version}:universal")
    implementation fg.deobf("com.ldtteam:blockui:${blockui_version}")
}
```

### Compiling MineColonies

> [!IMPORTANT]
> Please report any issues you encounter, as there might be discrepancies with the documentation. Make sure you know what you're doing; we are not responsible for corrupted workspaces or OS issues.

#### Setup Java

A Java JDK is required to compile MineColonies. **Java 17** is strictly required for Minecraft 1.19.2.

1. Download and install **Java JDK 17** (Amazon Corretto 17 or Eclipse Adoptium Temurin 17).
   * **Windows:** Download the JDK 17 installer from [Amazon Corretto](https://aws.amazon.com/corretto/) or [Eclipse Adoptium](https://adoptium.net/). In the installer options, ensure that `Set JAVA_HOME` and `Add to Path` are enabled.
   * **Linux:** Install JDK 17 using your distribution package manager:
     * Arch Linux: `pacman -S jdk17-openjdk`
     * Ubuntu / Debian: `apt-get install openjdk-17-jdk`
     * Fedora: `dnf install java-17-openjdk-devel`
     * Gentoo: `emerge dev-java/openjdk-bin:17`
2. Open your terminal and run `javac -version`. If it outputs version `17.x`, you are ready.

##### Troubleshooting Java on Windows

If the `javac` command is not recognized on Windows:

* Open **Environment Variables** (`System Properties → Advanced → Environment Variables`).
* Under **System Variables**, click **New**:
  * Variable name: `JAVA_HOME`
  * Variable value: `C:\Program Files\Amazon Corretto\jdk17.0.20_10` (or your actual JDK 17 install directory).
* In **System Variables**, locate `Path`, click **Edit**, and append `%JAVA_HOME%\bin`.

#### Setup Gradle

MineColonies includes the **Gradle Wrapper** (`gradlew` on Linux/macOS, `gradlew.bat` on Windows), which automatically downloads and executes the exact required version of Gradle (8.1.1). You do not need to install Gradle manually.

#### Setup Git

Git is used to clone the repository and keep your local branch updated.

1. Download and install Git from [git-scm.com](https://git-scm.com/download/).
2. (*Optional*) Download a Git GUI client such as GitKraken, GitHub Desktop, SourceTree, or Fork. A full list is available at [Git GUI Clients](https://git-scm.com/downloads/guis).

#### Clone MineColonies (Command Line)

1. Open your terminal.
2. Navigate to your desired workspace directory (referred to as `basefolder`).
3. Clone the repository:

   ```bash
   git clone https://github.com/Minecolonies/minecolonies.git
   ```

4. Your directory structure should look like:

   ```text
   basefolder/
   └── minecolonies/
       ├── build.gradle
       ├── gradle.properties
       └── src/
   ```

#### Clone MineColonies (GitKraken)

1. Open GitKraken.
2. Click `File → Clone Repo`.
3. Select GitHub.com and choose a base destination folder.
4. Search for `minecolonies` and select the repository by `ldtteam`.

   ![GitKraken Clone Repository Dialog](https://i.imgur.com/jVTXyCJ.png)

5. Click **Clone the Repo**.

#### Compile MineColonies (Command Line)

1. Open your terminal in the `minecolonies` directory.
2. Run the build command:

   ```bash
   ./gradlew build
   ```

   *(On Windows Command Prompt: `gradlew.bat build`)*
   * On the first run, ForgeGradle downloads Minecraft Forge and required dependencies.
   * When finished, `BUILD SUCCESSFUL` will be displayed.
3. Locate the built jar in `build/libs/`:
   * `build/libs/minecolonies-0.0.1-LOCAL-1.19.2.jar`
4. Copy the jar into your Minecraft `mods/` directory.
5. Alternatively, launch a Minecraft test client with the mod loaded:

   ```bash
   ./gradlew runClient
   ```

#### Compile MineColonies (IntelliJ IDEA)

1. Open IntelliJ IDEA and choose **Open**, then select the project folder containing `build.gradle`.
2. Allow Gradle to import dependencies and configure the project.

   ![IntelliJ IDEA Project Setup](https://i.imgur.com/ewccjDZ.png)

3. Open the Gradle tool window (`View → Tool Windows → Gradle`).
4. Under `Tasks → fg_runs`, run `genIntellijRuns`.
5. Restart or reload IntelliJ.
6. Select `runClient` or `runServer` from the run configuration dropdown in the top-right and click **Run**.
7. To package a runnable jar, execute the `build` or `shadowJar` task from the Gradle tool window.

##### Troubleshooting IntelliJ Sync

If Gradle synchronization fails:

1. Go to `File → Project Structure → Project` and ensure **SDK** is set to **Java 17**.
2. Go to `File → Settings → Build, Execution, Deployment → Build Tools → Gradle` and ensure **Gradle JVM** is set to **Java 17**.

#### Updating Your Repository

To pull the latest commits into your local branch:

1. Open your terminal in the repository directory.
2. Ensure you do not have uncommitted changes (`git status`).
3. Pull the latest commits:

   ```bash
   git pull origin festercolonies-1.19.2
   ```

#### General Troubleshooting

* **Out of Memory during Gradle builds:** Adjust Gradle memory settings in `gradle.properties` (`org.gradle.jvmargs=-Xmx3G`).
* **Unresolved dependencies after branch switch:** Refresh Gradle dependencies from the Gradle tool window in IntelliJ, or run `./gradlew --refresh-dependencies`.

### Contributing

#### Submitting a Pull Request

1. Create a GitHub account if you do not have one.
2. Fork the repository on GitHub.
3. Commit your changes locally.
4. Push your changes to your fork.
5. Open a Pull Request from your branch and fill in the PR template.
6. Wait for feedback and reviews!
