package cryptoPortfolio.exchange;

import java.math.BigDecimal;
import java.net.URL;
import java.util.EnumSet;

import cryptoPortfolio.exchange.liveCoin.CryptoCoinOnLiveCoin;


public interface Exchange {
	
	
	
	// Getter and Setter
	public String getName();
	public void setName(String name);
	
	public URL getUrl();
	public void setUrl(String url);
	
	// Methods
	public BigDecimal getLastSellPrice(String currencyPair);
	public URL getURLLastTade(String currencyPair);
	public String getCurrencyPair(CryptoCoin first ,CryptoCoin second);
	public EnumSet<CryptoCoinOnLiveCoin> getAllCryptoCoins();
	public boolean trades(CryptoCoin cryptoCoin);
	public BigDecimal getBtcPrice();
	public BigDecimal getEthPrice();
	

}
