class Archive: Screen() {
    val archiveList: MutableList<MutableList<String>> = mutableListOf()

    override val massage = "Архив, введите номер команды: " +
            "\n1. Создать архив. " +
            "\n2. Выбрать архив." +
            "\n3. Выход"


    override fun moveTo() {
        println(massage)
        while(true){
            try {
                when(userInput()){

                    1 -> {
                        val archiveCreator = ArchiveCreator()
                        archiveCreator.moveTo()
                        if (archiveCreator.isCreate == true) {
                            archiveList.add(archiveCreator.newArchive)
                            println(massage)
                        } else {
                            println("вы вернулись в меню архива, без создания нового архива.")
                            println(massage)
                        }
                    }
                    2 -> TODO()
                    3 -> return
                    !in 1..3 -> {
                        println("Такого номера команды нет, введите команду снова.")
                        println(massage)
                    }
                }
            }catch (e: Exception) {
                println("Вы ввёли не цифру, следует вводить цифру.")
                println(massage)
            }
        }
    }
}