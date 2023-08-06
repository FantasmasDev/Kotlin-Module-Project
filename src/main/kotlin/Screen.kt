import java.util.Scanner

abstract class Screen{
    abstract val massage: String
    var command: String = ""
    fun userInput(){


        when(command){

            "1" -> TODO()
             "2" -> TODO()
            "3" -> TODO()
            else -> println("Неверная комманда")
        }
    }

}