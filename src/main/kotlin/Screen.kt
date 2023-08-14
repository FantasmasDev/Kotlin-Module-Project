import java.util.*

sealed class Screen(val options: List<String>) {
    object Archive : Screen(listOf(
        "Создание архива.",
        "Выбрать архив.",
        "Выход.",))
    object CreateArchive : Screen(listOf(
        "Создать архив.",
        "Назад.",))
    object Notes : Screen(listOf(
        "Создание заметок.",
        "Выбрать заметку.",
        "Назад.",))
    object CreateNotes : Screen(listOf(
        "Создать заметку.",
        "Назад",))
    object Note : Screen(listOf(
        "Смотреть заметку",
        "Назад",))

    fun showMenu() {
        for ((index, position) in options.withIndex()) {
            println("$index. $position")
        }
    }

    val archive = Archive(mutableListOf())

    fun navigateTo(screen: Screen) {
        screen.showMenu()
        val command = userInput(screen)
        when(screen) {
            is Archive -> when(command) {
                0 -> navigateTo(CreateArchive)
                1 -> {
                    archive.showArchive()
                    if(archive.checkEmpty()) {
                        navigateTo(Archive)
                    }else{
                        archive.selectArchivePosition()
                        navigateTo(Notes)
                    }
                }
                2 -> return
            }
            is CreateArchive -> when(command){
                0 -> {
                    archive.archiveList.add(mutableListOf())
                    println("архив добавлен")
                    navigateTo(Archive)
                }
                1 -> navigateTo(Archive)
            }
            is Notes -> when(command) {
                0 -> navigateTo(CreateNotes)
                1 -> {
                    archive.showNoteArchive()
                    if(archive.checkEmpty(archive.archivePosition)){
                        navigateTo(Notes)
                    }else{
                        archive.selectNotePosition()
                        navigateTo(Note)
                    }
                }
                2 -> navigateTo(Archive)
            }
            is CreateNotes -> when(command){
                0 -> {
                    archive.addArchiveNote()
                    navigateTo(Notes)
                }
                1 -> navigateTo(Notes)
            }
            is Note -> when(command){
                0 -> {
                    archive.showNote()
                    navigateTo(Note)
                }
                1 -> navigateTo(Notes)
            }
        }
    }

    fun userInput(screen: Screen): Int{
        while(true){
            try {
                val command = Scanner(System.`in`).nextLine().toInt()
                if(command <= screen.options.size - 1 && command >= 0){
                    return command
                }else{
                    println("Команды под таким номером нет, введите комманду из списка")
                }
            } catch (e: Exception) {
                println("Вы ввели не цифру, следует вводить цифру.")
            }
        }
    }
}