package cryptoPortfolio.wallet.model;

import java.math.BigDecimal;
import java.util.Date;

import cryptoPortfolio.crypotcoinlist.CryptoCoinList;

public class WalletPosition {

	private Date buyDate;
	private String cryptoCoin;
	private BigDecimal quantity;
	private BigDecimal buyPrice;	
	
	/*
	 * Getter and Setter
	 */
	
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
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
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

}
