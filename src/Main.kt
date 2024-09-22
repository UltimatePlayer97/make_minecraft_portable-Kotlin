import java.io.*
import java.nio.file.*
import java.util.Scanner

class MMcP(var instanceName: String, var instanceDir: String, var minecraft: ProcessBuilder)

fun modifyMmcp(mmcp: MMcP, buf: StringBuilder) {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Name:\t")
        try {
            val name = scanner.nextLine()
            mmcp.instanceName = name
            buf.clear()
        } catch (e: Exception) {
            println("Error:\n ${e.message}")
            buf.clear()
            continue
        }

        println("Location:\t")
        try {
            val location = scanner.nextLine()
            buf.clear()
        } catch (e: Exception) {
            println("Failed to parse location")
        }
    }
}

fun main() {
    println("MMcP - Make Minecraft Portable")

    val minecraft: ProcessBuilder
    val launcherDir: String

    when {
        System.getProperty("os.name").startsWith("Windows") -> {
            launcherDir = "C:\\\\XboxGames\\\\Minecraft Launcher\\\\Content\\\\Minecraft.exe"
        }
        System.getProperty("os.name").startsWith("Linux") -> {
            launcherDir = "minecraft-launcher"
        }
        else -> {
            println("MMcP does not yet support your platform, stay tuned for more info.")
            return
        }
    }

    if(Files.exists(Paths.get(launcherDir))) {
        minecraft = ProcessBuilder(launcherDir)
    } else {
        println("There was an issue picking up the launcher. MMcP does not implement a function to auto install.")
        println("Please download Minecraft Launcher at https://www.minecraft.net/en-us/download")
        return
    }

    val buf = StringBuilder()
    val mmcp = MMcP("Vanilla", "", minecraft)

    val scanner = Scanner(System.`in`)
    while (true) {
        for (msg in tuiHelperString(mmcp)) {
            println(msg)
        }

        buf.clear()
        val input = scanner.nextLine()
        when {
            input.contains("S", ignoreCase = true) -> {
                println("Starting Minecraft launcher, please wait....")
                mmcp.minecraft.start()
            }
            input.contains("E", ignoreCase = true) -> {
                println("Showing current installation status. (This feature is not yet fully implemented so please be patient)")
            }
            input.contains("0") -> {
                println("Thank you for using MMcP.")
                break
            }
            else -> {
                println("Invalid input, please try again.")
            }
        }
    }
}

fun tuiHelperString(mmcp: MMcP): List<String> {
    return listOf(
        "[S] Start Minecraft Launcher",
        "[E] Show installation status",
        "[0] Exit MMcP"
    )
}
