import java.io.*
import java.nio.file.*
import java.util.Scanner

data class GameInstance(var instanceName: String, var instanceDir: String)

class MMcP(private val minecraftLauncher: ProcessBuilder) {
    private val instances = mutableListOf<GameInstance>()
    private val defaultDir = Paths.get(System.getProperty("user.dir"), "MMcP_ Instances")

    init {
        // Create default directory for storing instances
        if (!Files.exists(defaultDir)) {
            Files.createDirectory(defaultDir)
            println("Default instance created at: $defaultDir")
        }
    }

    fun createInstance(name: String, dir: String){
        val scanner = Scanner(System.`in`)

        println("Enter the Minecraft versions: ")
        val minecraftVersion = scanner.nextLine()

        val instanceDir = if (dir.isNullOrBlank()) {
            val newDir = defaultDir.resolve(name)
            if(!Files.exists(newDir)){
                Files.createDirectory(newDir)
                println("Instance created at: $newDir")
            }
            newDir.toFile()
        } else {
            dir
        }

        val instance = GameInstance(name, instanceDir.toString())
        instances.add(instance)
        println("Created Instance: $name at directory: $instanceDir")
    }

    fun listInstances() {
        if (instances.isEmpty()){
            println("No instances found")
            println("Using Vanilla Minecraft Instance")
        } else {
            println("Game instances:")
             instances.forEach { "- ${it.instanceName} (Directory: ${it.instanceDir})" }
            }
        }

    fun deleteInstance(name: String) {
        val instanceToRemove = instances.find { it.instanceName == name }
        if (instanceToRemove != null) {
            instances.remove(instanceToRemove)
            println("Deleted Instance: $name")
        } else {
            println("No instances called $name found")
        }
    }

    fun startMinecraft() {
        println("Starting Minecraft Launcher please wait.....")
        minecraftLauncher.start()
    }
}

fun main() {
    println("MMcP - Make Minecraft Portable")



    val launcherDir = when {
        System.getProperty("os.name").startsWith("Windows") -> {
            "C:\\XboxGames\\Minecraft Launcher\\Content\\Minecraft.exe"
        }

        System.getProperty("os.name").startsWith("Linux") -> {
            "minecraft-launcher"
        }

        else -> {
            println("MMcP does not yet support your platform, stay tuned for more info.")
            return
        }
    }

    if (Files.exists(Paths.get(launcherDir))) {
        val minecraft = ProcessBuilder(launcherDir)
        val mmcp = MMcP(minecraft)
        manageInstances(mmcp)
    } else {
        println("There was an issue picking up the launcher. MMcP does not implement a function to auto install.")
        println("Please download Minecraft Launcher at https://www.minecraft.net/en-us/download")
        return
    }
}

fun manageInstances(mmcp: MMcP) {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("\nSelect an option:")
        println("[C] Create Instance")
        println("[L] List Instances")
        println("[D] Delete Instance")
        println("[S] Start Minecraft Launcher")
        println("[0] Exit MMcP")

        when (scanner.nextLine().uppercase()) {
            "C" -> {
                println("Enter instance name: ")
                val name = scanner.nextLine()
                println("Enter instance dir: ")
                val dir = scanner.nextLine()
                mmcp.createInstance(name, dir)
            }
            "L" -> mmcp.listInstances()
            "D" -> {
                println("Enter instance name to delete: ")
                val name = scanner.nextLine()
                mmcp.deleteInstance(name)
            }
            "S" -> mmcp.startMinecraft()
            "0" -> {
                println("Thank you for using MMcP")
                return
            }
            else -> println("Invalid input, please try again.")
        }
    }
}