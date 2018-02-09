package cryptoPortfolio.exchange.liveCoin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;
import cryptoPortfolio.exchange.AbstractExchange;
import cryptoPortfolio.exchange.liveCoin.model.LiveCoinJson;

public class LiveCoin extends AbstractExchange  {

	private final static String LIVECOIN_URL = "https://api.livecoin.net//exchange/";
	private CryptoCoinOnLiveCoin coinOnLiveCoin = new CryptoCoinOnLiveCoin();

	public LiveCoin() {

		this.setName("LiveCoin");
		this.setUrl(LIVECOIN_URL);
		this.setExchangeCryptoCoin(coinOnLiveCoin.getCryptoCoinMap());
		this.setBtcPrice(getBtcPriceFromExchange());
		this.setEthPrice(getEthPriceFromExchange());
	}

	@Override
	public BigDecimal getLastSellPrice(String currencPair) {
		System.out.println("get LastSellPrice for :" + currencPair);
		ArrayList<LiveCoinJson> coinList = new ArrayList<LiveCoinJson>();
		LiveCoinJson liveCoin = new LiveCoinJson();

		try {
			// URL queryUrl = new
			// URL("https://api.livecoin.net/exchange/order_book?currencyPair=LTC/BTC");
			URL queryUrl = getURLLastTade(currencPair);
			HttpURLConnection connection = (HttpURLConnection) queryUrl.openConnection();
			connection.setDoOutput(true);

			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JsonParser parser = Json.createParser(rd);
			String key = null;
			String value = null;
			while (parser.hasNext()) {
				final Event event = parser.next();
				switch (event) {
				case KEY_NAME:
					key = parser.getString();

					// Add Coin Oject to List
					if (key.contains("time")) {
						if (liveCoin.isSet()) {
							coinList.add(liveCoin);
							liveCoin = new LiveCoinJson();
						}
					}
					break;
				case VALUE_STRING:
					String string = parser.getString();
					if (key.contains("type")) {
						liveCoin.setType(string);
					}
					break;
				case VALUE_NUMBER:
					BigDecimal number = parser.getBigDecimal();
					switch (key) {
					case "time":
						liveCoin.setTime(number);
						break;
					case "id":
						liveCoin.setId(number);
						break;
					case "price":
						liveCoin.setPrice(number);
						break;
					case "quantity":
						liveCoin.setQuantity(number);
						break;

					default:
						break;
					}
					break;
				case VALUE_TRUE:
					break;
				case VALUE_FALSE:
					break;
				default:
					break;
				}
			}

			parser.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Just get the first Rate ; this is the Last traded Rate
		if (coinList.isEmpty()) {
			return null;
		} else
			return coinList.get(0).getPrice();
	}

	@Override
	public boolean isTradable(String cryptoCoin) {
		boolean trades = false;
		for (String cryptoCoinOnExchange : coinOnLiveCoin.getCryptoCoinMap().values()) {
			if (cryptoCoin.toString().contains(cryptoCoinOnExchange)) {
				trades = true;
			}

		}
		return trades;
	}

	public BigDecimal getBtcPriceFromExchange() {

		return getLastSellPrice(getCurrencyPair(coinOnLiveCoin.getCryptoCoinMap().get(1) 
				, coinOnLiveCoin.getCryptoCoinMap().get(0) ));
	}

	public BigDecimal getEthPriceFromExchange() {
		return getLastSellPrice(getCurrencyPair(coinOnLiveCoin.getCryptoCoinMap().get(2) 
				, coinOnLiveCoin.getCryptoCoinMap().get(0) ));
	}

	@Override
	public String mapPortfolioCointoExchangeCoin(int number) {
		return null;
	}

	@Override
	public String getCurrencyPair(String first, String second) {
		return first + "/" + second;
	}




}
