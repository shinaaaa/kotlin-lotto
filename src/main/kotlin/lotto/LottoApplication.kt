package lotto

import lotto.domain.Lottos
import lotto.domain.Price
import lotto.domain.ProfitRate
import lotto.domain.WinningNumber
import lotto.domain.generator.LottoAutoStrategy
import lotto.domain.generator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice() ?: 0
    val lottoCount = Price(inputPrice).getLottoCount()
    OutputView.printBoughtLotto(lottoCount)

    val lottos = LottoGenerator().generate(lottoCount, LottoAutoStrategy())
    OutputView.printBoughtLottos(lottos)

    val inputWinningNumber: List<String> = InputView.inputWinningNumber()
    val winningNumber = WinningNumber(inputWinningNumber)

    val inputBonusNumber = InputView.inputBonusNumber() ?: 0

    val matchResult = Lottos(lottos).matchWinningNumber(winningNumber.value, inputBonusNumber)
    OutputView.printLottoMatchResult(matchResult)

    val profitRate = ProfitRate(matchResult, inputPrice)
    val result = profitRate.calculate()
    OutputView.printProfitRate(result)
}