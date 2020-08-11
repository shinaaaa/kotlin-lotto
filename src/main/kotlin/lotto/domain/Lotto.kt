package lotto.domain

private const val COUNT_OF_NUMBERS = 6

class Lotto() {
    var numbers: Set<LottoNumber> = emptySet()
    var countOfMatch: Int = 0
        private set

    init {
        numbers = (MIN_NUMBER..MAX_NUMBER).shuffled().subList(0, COUNT_OF_NUMBERS)
            .sorted().map { LottoNumber(it) }.toSet()
    }

    constructor(prizeNumberString: String) : this() {
        numbers = prizeNumberString.split(",").asSequence().sorted().map { LottoNumber(it.toInt()) }.toSet()
        require(numbers.size == COUNT_OF_NUMBERS) { "중복되지 않는 6개의 숫자를 입력해주세요" }
    }

    fun checkPrize(lotto: Lotto): Prize {
        countOfMatch = numbers.count { lotto.numbers.contains(it) }
        return Prize.getPrize(countOfMatch)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}