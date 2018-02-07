package cryptoPortfolio.wallet;

import java.math.BigDecimal;
import java.util.Date;

import cryptoPortfolio.exchange.CryptoCoin;

public class Position {
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public CryptoCoin getCryptoCoin() {
		return cryptoCoin;
	}
	public void setCryptoCoin(CryptoCoin cryptoCoin) {
		this.cryptoCoin = cryptoCoin;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	private Date buyDate;
	private CryptoCoin cryptoCoin;
	private BigDecimal quantity;
    private BigDecimal buyPrice;	

}
