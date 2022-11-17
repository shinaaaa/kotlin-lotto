package calculator.utils

object Separator {

    fun findInString(str: String) =
        Regex("(?<=//)(.*?)(?=\n)").find(str)?.value ?: ""

    fun divideBySeparator(separator: String, text: String): List<String> {
        if (separator.isBlank()) return text.split(Regex("[,:]"))
        return text.split(separator)
    }

    fun getNextValue(text: String): String {
        return text.substringAfter("\n")
    }
}