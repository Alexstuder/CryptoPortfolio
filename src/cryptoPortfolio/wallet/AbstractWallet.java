package cryptoPortfolio.wallet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;
import cryptoPortfolio.wallet.model.WalletPosition;

public abstract class AbstractWallet implements Wallet{
	
	private String name;
	private ArrayList<WalletPosition> positionList = new ArrayList<WalletPosition>();
	private HashMap<Integer , String> walletCryptoCoin  ;
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<WalletPosition> getPositionList() {
		return positionList;
	}

	public void setPositionList(ArrayList<WalletPosition> positionList) {
		this.positionList = positionList;
	}

	public HashMap<Integer , String> getWalletCryptoCoin() {
		return walletCryptoCoin;
	}

	public void setWalletCryptoCoin(HashMap<Integer , String> walletCryptoCoin) {
		this.walletCryptoCoin = walletCryptoCoin;
	}

	public SimpleDateFormat getDateformat() {
		return dateformat;
	}

	public void setDateformat(SimpleDateFormat dateformat) {
		this.dateformat = dateformat;
	}

}
