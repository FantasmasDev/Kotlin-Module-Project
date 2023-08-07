fun main(args: Array<String>) {
    println()
    println(1 === 0x01)
    val archiveScreen = Archive()
    println(archiveScreen.archiveList)
    archiveScreen.moveTo()
    println(archiveScreen.command)
}

