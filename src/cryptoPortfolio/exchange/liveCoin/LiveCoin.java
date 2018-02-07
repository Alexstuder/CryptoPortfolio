package cryptoPortfolio.exchange.liveCoin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import ch.alexstuder.livecoin.model.LiveCoinJson;
import cryptoPortfolio.exchange.CryptoCoin;
import cryptoPortfolio.exchange.Exchange;

public class LiveCoin implements Exchange {

	public String name = "";
	public URL url = null;
	public EnumSet<CryptoCoinOnLiveCoin> allCryptoCoins = null;
	public BigDecimal btcPrice;
	public BigDecimal ethPrice;
	private final static String LIVECOIN_URL = "https://api.livecoin.net//exchange/" ;

	public LiveCoin() {

		this.setName("LiveCoin");
		this.setUrl(LIVECOIN_URL);
        this.allCryptoCoins = getAllCryptoCoins();
        this.btcPrice = getBtcPriceFromExchange();
        this.ethPrice = getEthPriceFromExchange();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name ;
	}

	@Override
	public URL getUrl() {
		return this.url;
	}

	@Override
	public void setUrl(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public URL getURLLastTade(String currencyPair) {
		URL functionLastTradeURL = null;
		try {
			functionLastTradeURL = new URL(this.getUrl().toString() + "last_trades?currencyPair=" + currencyPair);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return functionLastTradeURL;
	}

	@Override
	public String getCurrencyPair(CryptoCoin first, CryptoCoin second) {
		return first + "/" + second;
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

		//Just get the first Rate ; this is the Last traded Rate
		if (coinList.isEmpty()) {
			return null;
		} else return coinList.get(0).getPrice();
	}

	@Override
	public EnumSet<CryptoCoinOnLiveCoin> getAllCryptoCoins() {
		 EnumSet<CryptoCoinOnLiveCoin> allCryptoCoins = EnumSet.allOf(CryptoCoinOnLiveCoin.class); 
		 
		return allCryptoCoins;
	}

	@Override
	public boolean trades(CryptoCoin cryptoCoin) {
		boolean trades = false ;
		for (CryptoCoinOnLiveCoin cryptoCoinOnExchange : this.getAllCryptoCoins()) {
			if (cryptoCoin.toString().contains(cryptoCoinOnExchange.toString())) {
				trades = true;
			}
			
		}
		return trades;
	}

	@Override
	public BigDecimal getBtcPrice() {
		
		return this.btcPrice;
	}

	@Override
	public BigDecimal getEthPrice() {
		return this.ethPrice;
	}
	
	public BigDecimal getBtcPriceFromExchange() {
		
		return getLastSellPrice(getCurrencyPair(CryptoCoin.BTC, CryptoCoin.USD));
	}
	
	public BigDecimal getEthPriceFromExchange() {
		return getLastSellPrice(getCurrencyPair(CryptoCoin.ETH, CryptoCoin.USD));
	}

}
