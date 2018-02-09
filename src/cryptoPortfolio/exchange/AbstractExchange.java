package cryptoPortfolio.exchange;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;
import cryptoPortfolio.exchange.liveCoin.CryptoCoinOnLiveCoin;

public abstract class AbstractExchange implements Exchange{

	private String name = "";
	private URL url = null;
	private HashMap<Integer , String> exchangeCryptoCoin = null;
//	private CryptoCoinList exchangeCryptoCoin  ;

	private BigDecimal btcPrice;
	private BigDecimal ethPrice;

	// **************************************************
	// * Getter and Setter
	// **************************************************

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public URL getURLLastTade(String currencyPair) {
		URL functionLastTradeURL = null;
		try {
			functionLastTradeURL = new URL(this.getUrl().toString() + "last_trades?currencyPair=" + currencyPair);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return functionLastTradeURL;
	}

	public BigDecimal getBtcPrice() {
		return btcPrice;
	}

	public void setBtcPrice(BigDecimal btcPrice) {
		this.btcPrice = btcPrice;
	}

	public BigDecimal getEthPrice() {
		return ethPrice;
	}

	public void setEthPrice(BigDecimal ethPrice) {
		this.ethPrice = ethPrice;
	}

	public HashMap<Integer, String> getExchangeCryptoCoin() {
		return exchangeCryptoCoin;
	}
	
	public void setExchangeCryptoCoin(HashMap<Integer, String> exchangeCryptoCoin) {
		this.exchangeCryptoCoin = exchangeCryptoCoin;
	}

}
