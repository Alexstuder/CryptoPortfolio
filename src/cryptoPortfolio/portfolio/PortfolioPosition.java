package cryptoPortfolio.portfolio;

import java.math.BigDecimal;
import java.util.Date;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;

public class PortfolioPosition {
	
	private Date date;
	private String Name ;
	private String cryptoCoin;
	private BigDecimal quantity;
	private BigDecimal rateToBtc;
    private BigDecimal priceBtcUSD;	
	private BigDecimal rateToEth;
	private BigDecimal priceEthUSD;
    private String bestExchange;
    
    
    
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCryptoCoin() {
		return cryptoCoin;
	}
	public void setCryptoCoin(String cryptoCoin) {
		this.cryptoCoin = cryptoCoin;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getRateToBtc() {
		return rateToBtc;
	}
	public void setRateToBtc(BigDecimal rateToBtc) {
		this.rateToBtc = rateToBtc;
	}
	public BigDecimal getPriceBtcUSD() {
		return priceBtcUSD.setScale(2,BigDecimal.ROUND_DOWN);
	}
	public void setPriceBtcUSD(BigDecimal priceBtcUSD) {
		this.priceBtcUSD = priceBtcUSD;
	}
	public BigDecimal getRateToEth() {
		return rateToEth;
	}
	public void setRateToEth(BigDecimal rateToEth) {
		this.rateToEth = rateToEth;
	}
	public BigDecimal getPriceEthUSD() {
		return priceEthUSD.setScale(2,BigDecimal.ROUND_DOWN);
	}
	public void setPriceEthUSD(BigDecimal priceEthUSD) {
		this.priceEthUSD = priceEthUSD;
	}




	public String getBestExchange() {
		return bestExchange;
	}
	public void setBestExchange(String bestExchange) {
		this.bestExchange = bestExchange;
	}
	
	@Override
	public String toString() {
		return "Date :"+this.getDate()
		      +" Name :"+this.getName()
		      +" CryptoCoin :"+this.getCryptoCoin()
		      +" Quantity :"+this.getQuantity()
		      +" Rate2BTC :"+this.getRateToBtc()
		      +" Price :"+this.getPriceBtcUSD()
		      +" Rate2ETH :"+this.getRateToEth()
		      +" Price :"+this.getPriceEthUSD()
		      +" Best Exchange :"+this.getBestExchange()
		      +"\n";
		
		
		
	}

}
