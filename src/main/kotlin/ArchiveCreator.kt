class ArchiveCreator: Screen() {
    override val massage = "Архив, введите номер команды: " +
            "\n1. Создать архив. " +
            "\n2. Назад"
    lateinit var newArchive: MutableList<String>
    var isCreate = false

    override fun moveTo() {
        println(massage)
        while(true){
            try {
                when (userInput()) {
                    1 -> {
                        println("Архив создан")
                        newArchive = createNewArchive()
                        isCreate = true
                        return
                    }

                    2 -> return
                    !in 1..2 -> {
                        println("Такого номера команды нет, введите команду снова")
                        println(massage)
                    }

                    else -> {
                        println("Вы ввёли не цифру, следует вводить цифру")
                        println(massage)
                    }
                }
            }catch (e: Exception) {
                println("Вы ввёли не цифру, следует вводить цифру.")
                println(massage)
            }
        }
    }

    fun createNewArchive(): MutableList<String>{
        val newArchive: MutableList<String> = mutableListOf()
        return  newArchive
    }
}