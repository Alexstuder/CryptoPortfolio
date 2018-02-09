package cryptoPortfolio.exchange;

import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;


public interface Exchange {
	
	
	
	// Getter and Setter
	public String getName();
	public void setName(String name);
	
	public URL getUrl();
	public void setUrl(String url);
	
	// Methods
	public BigDecimal getLastSellPrice(String currencyPair);
	public URL getURLLastTade(String currencyPair);
	public String getCurrencyPair(String first ,String second);
	public boolean isTradable(String cryptoCoin);
	public BigDecimal getBtcPrice();
	public BigDecimal getEthPrice();
	
	public String mapPortfolioCointoExchangeCoin(int number);
	public HashMap<Integer, String> getExchangeCryptoCoin();

}
