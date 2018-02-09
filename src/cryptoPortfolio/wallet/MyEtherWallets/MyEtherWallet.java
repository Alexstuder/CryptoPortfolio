package cryptoPortfolio.wallet.MyEtherWallets;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;
import cryptoPortfolio.wallet.AbstractWallet;
import cryptoPortfolio.wallet.Wallet;
import cryptoPortfolio.wallet.model.WalletPosition;

public class MyEtherWallet extends AbstractWallet{

	private MyEtherWalletCoinList myEtherCoinList = new MyEtherWalletCoinList();

	public MyEtherWallet() {
		super.setName("MyEtherWallet Alexstuder");
		super.setWalletCryptoCoin( myEtherCoinList.getCryptoCoinMap());
		try {
			getMyEthereumWalletPosition();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getMyEthereumWalletPosition() throws ParseException {
		
		WalletPosition swissBorg = new WalletPosition();
		swissBorg.setCryptoCoin(myEtherCoinList.getCryptoCoinMap().get(3));
		Date buyDate = new Date();
		buyDate = super.getDateformat().parse("2017-12-07");
		swissBorg.setBuyDate(buyDate);
		swissBorg.setBuyPrice(BigDecimal.valueOf(5000));
		swissBorg.setQuantity(BigDecimal.valueOf(60500));
		
		super.getPositionList().add(swissBorg);

		WalletPosition bitcoins = new WalletPosition();
		bitcoins.setCryptoCoin(myEtherCoinList.getCryptoCoinMap().get(1).toString());
		buyDate = new Date();
		buyDate = super.getDateformat().parse("2013-12-14");
		bitcoins.setBuyDate(buyDate);
		bitcoins.setBuyPrice(BigDecimal.valueOf(600));
		bitcoins.setQuantity(BigDecimal.valueOf(5));

		super.getPositionList().add(bitcoins);
		
		WalletPosition ethereum = new WalletPosition();
		ethereum.setCryptoCoin(myEtherCoinList.getCryptoCoinMap().get(2).toString());
		buyDate = new Date();
		buyDate = super.getDateformat().parse("2017-12-14");
		ethereum.setBuyDate(buyDate);
		ethereum.setBuyPrice(BigDecimal.valueOf(73800));
		ethereum.setQuantity(BigDecimal.valueOf(70));

		super.getPositionList().add(ethereum);
		
		
		
	}

	
}
