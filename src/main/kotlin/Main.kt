import file.FindService


fun main(args: Array<String>) {
    val fileNameMask = args[0]
    val finder = FindService()
    val foundFiles = finder.find(fileNameMask)
    println(foundFiles)
}