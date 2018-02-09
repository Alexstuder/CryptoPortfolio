package cryptoPortfolio;

import cryptoPortfolio.crypotcoinlist.AbstractCryptoCoinList;

public class MyCryptoCoinList extends AbstractCryptoCoinList{

	public MyCryptoCoinList() {
	   fillCryptoCoinList();
	}
	
	public enum Coin{
		BTC,ETH,USD,EURO
		
	}
	
	@Override
	public void fillCryptoCoinList() {
		
		// Fill your own CryptoCoinList
		
		super.getCryptoCoinMap().put(0, "U.S. Dollars");
		super.getCryptoCoinMap().put(1, "Bitcoin");
		super.getCryptoCoinMap().put(2, "Ethereum");
		super.getCryptoCoinMap().put(3, "SwissCyBorg");
		
	}

}
