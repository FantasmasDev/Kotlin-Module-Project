import java.util.*

class Archive(var archiveList: MutableList<MutableList<String>>) {
    var archivePosition = 0
    var notePosition = 0

    fun showArchive(){
        println("Архив:")
        for((index, position) in archiveList.withIndex()) {
            println("$index. $position")
        }
    }

    fun showNoteArchive(){
        println("Заметки:")
        for((index, position) in archiveList[archivePosition].withIndex()) {
            println("$index. $position")
        }
    }

    fun showNote(){
        println(archiveList[archivePosition][notePosition])
    }

    fun addArchiveNote(){
        while(true){
            println("Введите заметку:")
            archiveList[archivePosition].add(Scanner(System.`in`).nextLine())
            return
        }
    }

    fun selectArchivePosition(){
        archivePosition = userInput()
    }

    fun selectNotePosition(){
        notePosition = userInput()
    }

    fun userInput(): Int{
        while(true){
            try {
                val command = Scanner(System.`in`).nextLine().toInt()
                if(command <= archiveList.size - 1 && command >= 0){
                    return command
                }else{
                    println("Команды под таким номером нет, введите комманду из списка")
                }
            } catch (e: Exception) {
                println("Вы ввели не цифру или архив пуст, следует вводить цифру.")
            }
        }
    }

    fun checkEmpty(): Boolean {
        if (archiveList.size == 0) {
            println("Архив пуст")
            return true
        }
        return false
    }
    fun checkEmpty(archivePosition: Int): Boolean {
        if (archiveList[archivePosition].size == 0) {
            println("Архив пуст")
            return true
        }
        return false
    }

}