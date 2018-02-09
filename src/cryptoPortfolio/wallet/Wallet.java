package cryptoPortfolio.wallet;

import java.util.ArrayList;

import cryptoPortfolio.wallet.model.WalletPosition;

public interface Wallet {
	
	public String getName();
	public ArrayList<WalletPosition> getPositionList();

}
