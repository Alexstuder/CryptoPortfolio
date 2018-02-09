package cryptoPortfolio.crypotcoinlist;

import java.util.HashMap;

public abstract class AbstractCryptoCoinList implements CryptoCoinList {
	
	private HashMap<Integer,String> cryptoCoinMap = new HashMap<Integer, String>();

	public HashMap<Integer, String> getCryptoCoinMap() {
		return cryptoCoinMap;
	}

	public void setCryptoCoinMap(HashMap<Integer, String> cryptoCoinMap) {
		this.cryptoCoinMap = cryptoCoinMap;
	}



}
