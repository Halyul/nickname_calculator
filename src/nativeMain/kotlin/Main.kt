const val UPPERCASELETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
val LOWERCASELETTERS = UPPERCASELETTERS.lowercase()
const val NUMBERS = "1234567890"
val LETTERS = UPPERCASELETTERS + LOWERCASELETTERS

fun main() {
    var newNickname = ""
    var nickname = enterNickname()
    var number = enterSeed()
    nickname.toList().forEach {
        newNickname += when {
            it.isDigit() -> NUMBERS[((NUMBERS.indexOf(it) + number) % NUMBERS.length).toInt()]
            it.isLowerCase() -> LOWERCASELETTERS[((LOWERCASELETTERS.indexOf(it) + number) % LOWERCASELETTERS.length).toInt()]
            it.isUpperCase() -> UPPERCASELETTERS[((UPPERCASELETTERS.indexOf(it) + number) % UPPERCASELETTERS.length).toInt()]
            else -> throw Exception("You should never be here!")
        }
    }
    println("Your new nickname is:")
    println(newNickname)
}

fun enterNickname():String {
    var nickname: String
    println("Enter nickname:")
    enterNickname@ while (true) {
        nickname = readln()
        if (nickname.any { it !in LETTERS && it !in NUMBERS }) {
            println("Invalid nickname! Re-enter nickname:")
        } else return nickname
    }
}

fun enterSeed(): Long {
    var seed = ""
    var number: Long
    println("Enter a seed:")
    while (true) {
        seed = readln()
        if (seed == "") {
            println("Invalid seed! Re-enter a seed:")
            continue
        }
        try {
            number = seed.toLong()
        } catch (e: NumberFormatException) {
            val seedByteArray = seed.encodeToByteArray()
            var seedByteString = ""
            seedByteArray.forEach {
                seedByteString += it.toString()
            }
            number = seedByteString.toLong()
        }
        return number
    }
}