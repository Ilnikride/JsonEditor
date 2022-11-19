package file

object SystemUtils {

    fun getCurrentDir(): String {
       return System.getProperty("user.dir")
    }
}