package file

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.isDirectory

/**
 * 1. пройти по всем файлам в директории
 * 2. Если текущий путь - директория, то провалиться в нее рекрсивнро
 * 3. если не директория и попал под маску файла то положить в результат
 *
 * */
class FindService {
    fun find(fileNameMask: String): List<Path> {
        val dir = SystemUtils.getCurrentDir()
        val result = mutableListOf<Path>()
        findInDir(Paths.get(dir), fileNameMask, result)
        return result
    }

    private fun findInDir(dir: Path, fileNameMask: String, result: MutableList<Path>) {
        Files.list(dir).forEach {
            if (it.toString().endsWith(fileNameMask, true)) {
                result.add(it)
            }
            if (it.isDirectory()) {
                findInDir(it, fileNameMask, result)
            }
        }

    }
}