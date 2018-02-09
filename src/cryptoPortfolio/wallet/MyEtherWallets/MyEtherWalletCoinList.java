package cryptoPortfolio.wallet.MyEtherWallets;

import cryptoPortfolio.crypotcoinlist.AbstractCryptoCoinList;

public class MyEtherWalletCoinList extends AbstractCryptoCoinList {
	
	
	public MyEtherWalletCoinList() {
		// Get the Coinlist for MyEtherwallet
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
