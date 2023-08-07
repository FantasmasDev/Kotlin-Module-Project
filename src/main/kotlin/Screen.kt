import java.lang.Exception
import java.util.Scanner

abstract class Screen{
    abstract val massage: String
    var command: Int = 0

    fun userInput(): Int{
        command = Scanner(System.`in`).nextLine().toInt()
        return command
    }

    abstract fun moveTo()

}


