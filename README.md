# MMcP - Make Minecraft Portable
A fork of https://github.com/NickGenghar/make_minecraft_portable, but made in Kotlin!

Having trouble making your Minecraft installation more portable? This tool will help you achieve that and more! Make Minecraft Portable, MMcP for short, is a simple program to manage Minecraft in a friendlier, more portable method, allowing for advance features such as custom installations (called `instance`s), custom locations and others. Originally, this project was made in Windows Batch script (sadly lost the original) as a pet project. With this rewrite, it is now aimed to become friendlier towards the larger masses.

## Features
Currently, the following features are available:
- [Complete]: Launch the (official) Minecraft Launcher (logins are managed by the Minecraft Launcher, not MMcP).
- [In-Progress]: Create, modify and remove `instances`.
- [Planned]: Download and install community-created contents (resource packs, mods, shaders, etc.) via providers (Modrinth, CurseForge, etc.).
- [Planned]: Auto-launch Minecraft via MMcP.
- [Planned]: Export `instances` into a compressed archive to be imported into other third-party launchers ([Prism Launcher](https://prismlauncher.org/), [Modrinth App](https://modrinth.com/app), [CurseForge App](https://www.curseforge.com/download/app), etc.).
- And many more! (Send ideas by creating a feature request, pull/merge request, etc.).

## How To Build the Project
Prerequesteries:
 - A Kotlin compiler. For normal users it is rcommended to install the [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows), but you may install kotlin compiler manually as well.
 - Git (Optional, but very helpful if you want to contribute code.)
 - A Java Developement Kit (JDK), if you do not have one installed already I heavily recommend installing [OpenJDK](https://adoptium.net/en-GB/temurin/releases/?version=21)

---
Use the green `Code` button around the middle top-right, choose your appropriate download method.

Alternatively, with `git`, `clone` the project to a working directory, then move into it.
```
git clone https://github.com/UltimatePlayer97/make_minecraft_portable-Kotlin.git

cd make_minecraft_portable_kotlin
```
Once you have entered the directory, you may either open it with IntelliJ to build the project **or** compile it manually, instructions provided below.

Compiling the project manually can be done so by going into the project's folder in terminal, then doing `kotlinc main.kt -include-runtime -d main.jar`

Then you can run the file by doing `java -jar main.jar`

## Kotlin Compiler
If you wish to download the Kotlin compiler manually, this guide will give instructions on how to do so:
 1. Download their latest release version `kotlin-compiler-2.0.20.zip` from their [GitHub Releases](https://github.com/JetBrains/kotlin/releases/tag/v2.0.20)
 2. Unzip the standalone directory, and add the `bin` directory to System PATH.

### How Do I add Kotlin to System PATH?
Adding Kotlin compiler to system path is pretty straightforward. Note: The following guide is intended for Windows users.
 1. Make sure you have the extrcted Kotlin compiler (as stated above)
 2. Click `Win key + R` and type `SystemPropertiesAdvanced`, this will give you a UAC prompt, if so click Yes
 3. Near the bottom, click `Environment Variables`
 4. Under System Variables, scroll down till you see `PATH`
 5. Click Edit when on PATH, then click `New` present in the right toolbar
 6. Now add the `bin` directory of the extracted ZIP file, make sure you have extracted it somewhere you don't normally mass delete files

For Linux users it is much easier to install Kotlin Compiler
 1. Install the SDKMAN! package if not already installed, do so by referring to [this](https://sdkman.io/install/) article
 2. Once installed, run `sdk install kotlin`

## Usage
The program does not receives command-line input. Instead, it provides what's known as a _Terminal User Interface_, TUI for short. Using this TUI, the user then selects the options provided. As of now, certain interactions are not implemented, instead, it will be implemented in the near future.
