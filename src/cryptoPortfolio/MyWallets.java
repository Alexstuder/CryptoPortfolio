package cryptoPortfolio.wallet;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cryptoPortfolio.exchange.CryptoCoin;
import cryptoPortfolio.exchange.Exchange;
import cryptoPortfolio.exchange.MyExchanges;

public class MyWallets {

	private ArrayList<Wallet> myWallets = new ArrayList<Wallet>();
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	public MyWallets() throws ParseException {
		getWallet();
	}

	public ArrayList<Wallet> getWallet() throws ParseException {

		MyEtherWallet myEtherWallet = new MyEtherWallet();
		myEtherWallet.setName("MyEtherWallet Alexstuder");

		Position swissBorg = new Position();
		swissBorg.setCryptoCoin(CryptoCoin.CHSB);
		Date buyDate = new Date();
		buyDate = dateformat.parse("2017-12-07");
		swissBorg.setBuyDate(buyDate);
		swissBorg.setBuyPrice(BigDecimal.valueOf(5000));
		swissBorg.setQuantity(BigDecimal.valueOf(60500));

		myEtherWallet.addpositionToList(swissBorg);

		Position ethereum = new Position();
		ethereum.setCryptoCoin(CryptoCoin.ETH);
		buyDate = new Date();
		buyDate = dateformat.parse("2017-12-14");
		ethereum.setBuyDate(buyDate);
		ethereum.setBuyPrice(BigDecimal.valueOf(73800));
		ethereum.setQuantity(BigDecimal.valueOf(90));

		myEtherWallet.addpositionToList(ethereum);

		Position bitcoins = new Position();
		bitcoins.setCryptoCoin(CryptoCoin.BTC);
		buyDate = new Date();
		buyDate = dateformat.parse("2013-12-14");
		bitcoins.setBuyDate(buyDate);
		bitcoins.setBuyPrice(BigDecimal.valueOf(600));
		bitcoins.setQuantity(BigDecimal.valueOf(5));

		myEtherWallet.addpositionToList(bitcoins);
		myWallets.add(myEtherWallet);

		return myWallets;
	}

	public void listAllWallets() {
		for (Wallet wallet : myWallets) {
			System.out.println(wallet.getName());
		}

	}

	public ArrayList<cryptoPortfolio.portfolio.Position> getRates(MyExchanges myExchanges) {

		ArrayList<cryptoPortfolio.portfolio.Position> positionsList = new ArrayList<cryptoPortfolio.portfolio.Position>();

		for (Wallet wallet : myWallets) {
			// Set the Name of the Wallet into Position

			for (cryptoPortfolio.wallet.Position walletPosition : wallet.getCryptoPositions()) {
				cryptoPortfolio.portfolio.Position position = new cryptoPortfolio.portfolio.Position();
				position.setName(wallet.getName());

				position.setCryptoCoin(walletPosition.getCryptoCoin());
				position.setDate(walletPosition.getBuyDate());
				position.setQuantity(walletPosition.getQuantity());

				for (Exchange exchange : myExchanges.getAllExchanges()) {
					if (exchange.trades(walletPosition.getCryptoCoin())) {
						System.out.println("GetLast SellPrice for the Wallet Coin" + walletPosition.getCryptoCoin());

						if (walletPosition.getCryptoCoin().toString().contains(CryptoCoin.BTC.toString())) {
							position.setRateToBtc(BigDecimal.valueOf(1.0));
						} else {
							position.setRateToBtc(exchange.getLastSellPrice(
									exchange.getCurrencyPair(walletPosition.getCryptoCoin(), CryptoCoin.BTC)));
						}

						if (walletPosition.getCryptoCoin().toString().contains(CryptoCoin.ETH.toString())) {
							position.setRateToEth(BigDecimal.valueOf(1.0));
						} else {
							position.setRateToEth(exchange.getLastSellPrice(
									exchange.getCurrencyPair(walletPosition.getCryptoCoin(), CryptoCoin.ETH)));
						}

						System.out.println("Set Price for EHT and BTC");

						position.setPriceBtcUSD(position.getQuantity()
								.multiply(position.getRateToBtc().multiply(exchange.getBtcPrice())));
						if (walletPosition.getCryptoCoin().toString().contains(CryptoCoin.BTC.toString())) {
							position.setPriceEthUSD(BigDecimal.valueOf(0));
						} else {
							position.setPriceEthUSD((position.getQuantity()
									.multiply(position.getRateToEth().multiply(exchange.getEthPrice()))));
						}
					}

				}

				positionsList.add(position);
			}

		}
		return positionsList;

	}

}
