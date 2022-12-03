import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInputText(name: String) = File("src/test/kotlin/resources", "$name.txt")
    .readText() //String

fun readInputLines(name: String) = File("src/test/kotlin/resources", "$name.txt")
    .readLines() //List<String>

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
