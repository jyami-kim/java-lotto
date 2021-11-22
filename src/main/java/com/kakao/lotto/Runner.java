package com.kakao.lotto;

import com.kakao.lotto.domain.LottoMachine;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.domain.WinLottoTicket;
import com.kakao.lotto.domain.WinResult;
import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.supportInfo.RankStatistic;
import com.kakao.lotto.ui.InputView;
import com.kakao.lotto.ui.OutputView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        PurchaseInfo purchaseInfo = new PurchaseInfo(inputView.inputLottoPurchase());
        LottoMachine lottoMachine = new LottoMachine(purchaseInfo);
        List<LottoTicket> userLottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTicket(userLottoTickets);


        List<Integer> winLotto = inputView.inputWinLotto();
        int bonus = inputView.inputLottoBonus();
        WinLottoTicket winLottoTicket = WinLottoTicket.of(winLotto, bonus);

        RankStatistic rankStatistic = new WinResult(userLottoTickets, winLottoTicket).createRankStatistic();
        OutputView.printLottoWinStatistic(rankStatistic, purchaseInfo);

    }
}
