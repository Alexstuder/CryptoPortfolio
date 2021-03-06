package cryptoPortfolio.exchange.liveCoin;

import cryptoPortfolio.crypotcoinlist.AbstractCryptoCoinList;

public class CryptoCoinOnLiveCoin extends AbstractCryptoCoinList {
	
	public CryptoCoinOnLiveCoin() {
		// Get the tradeble CryptoList for LiveCoin
		fillCryptoCoinList();
	}

	@Override
	public void fillCryptoCoinList() {
		super.getCryptoCoinMap().put(0, "USD");
		super.getCryptoCoinMap().put(1, "BTC");
		super.getCryptoCoinMap().put(2, "ETH");
		super.getCryptoCoinMap().put(3, "CHSB");

	}

}
