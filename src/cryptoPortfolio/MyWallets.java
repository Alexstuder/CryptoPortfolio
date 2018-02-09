package cryptoPortfolio;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import cryptoPortfolio.exchange.Exchange;
import cryptoPortfolio.wallet.Wallet;
import cryptoPortfolio.wallet.MyEtherWallets.MyEtherWallet;

public class MyWallets {

	private ArrayList<Wallet> myWallets = new ArrayList<Wallet>();
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	public MyWallets() throws ParseException {
		getWallet();
	}

	public ArrayList<Wallet> getWallet() throws ParseException {

		MyEtherWallet myEtherWallet = new MyEtherWallet();
		myWallets.add(myEtherWallet);

		return myWallets;
	}

	public void listAllWallets() {
		for (Wallet wallet : myWallets) {
			System.out.println(wallet.getName());
		}

	}

	public ArrayList<cryptoPortfolio.portfolio.PortfolioPosition> getRates(MyExchanges myExchanges) {

		ArrayList<cryptoPortfolio.portfolio.PortfolioPosition> positionsList = new ArrayList<cryptoPortfolio.portfolio.PortfolioPosition>();

		for (Wallet wallet : myWallets) {

			for (cryptoPortfolio.wallet.model.WalletPosition walletPosition : wallet.getPositionList()) {
				cryptoPortfolio.portfolio.PortfolioPosition position = new cryptoPortfolio.portfolio.PortfolioPosition();
				position.setName(wallet.getName());

				position.setCryptoCoin(walletPosition.getCryptoCoin());
				position.setDate(walletPosition.getBuyDate());
				position.setQuantity(walletPosition.getQuantity());

				for (Exchange exchange : myExchanges.getAllExchanges()) {
					if (exchange.isTradable(walletPosition.getCryptoCoin())) {
						System.out.println("GetLast SellPrice for the Wallet Coin" + walletPosition.getCryptoCoin());

						if (walletPosition.getCryptoCoin().toString().contains("BTC")) {
							position.setRateToBtc(BigDecimal.valueOf(1.0));
						} else {
							position.setRateToBtc(exchange.getLastSellPrice(
									exchange.getCurrencyPair(walletPosition.getCryptoCoin(), "BTC")));
						}

						if (walletPosition.getCryptoCoin().toString().contains("ETH")) {
							position.setRateToEth(BigDecimal.valueOf(1.0));
						} else {
							position.setRateToEth(exchange.getLastSellPrice(
									exchange.getCurrencyPair(walletPosition.getCryptoCoin(), "ETH")));
						}

						System.out.println("Set Price for EHT and BTC");

						position.setPriceBtcUSD(position.getQuantity()
								.multiply(position.getRateToBtc().multiply(exchange.getBtcPrice())));
						if (walletPosition.getCryptoCoin().toString().contains("BTC")) {
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
