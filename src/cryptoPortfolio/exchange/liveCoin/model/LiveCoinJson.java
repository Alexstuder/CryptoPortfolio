package cryptoPortfolio.exchange.liveCoin.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class LiveCoinJson {

	private Timestamp time;
	private BigDecimal id;
	private BigDecimal price;
	private BigDecimal quantity;
	private String type;
	
	
	private static final BigDecimal ONE_BILLION = new BigDecimal(1000000000L);

	public LiveCoinJson() {
		this.time = null;
		this.id = null;
		this.price = null;
		this.quantity = null;
		this.type = null;
	}

	/**
	 * Proof if coin has all Attributs set
	 * 
	 * @return
	 */
	public boolean isSet() {
		boolean isSet = false;

		if (this.time != null && this.id != null && this.price != null && this.quantity != null && this.type != null) {
			isSet = true;

		}

		return isSet;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(BigDecimal time) {
		
	    long seconds = time.longValue();
	    int nanoseconds = extractNanosecondDecimal(time, seconds);

	    Timestamp ts = new Timestamp(seconds * 1000);
	    ts.setNanos(nanoseconds);
	    
		this.time = ts;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	 public static int extractNanosecondDecimal(BigDecimal value, long integer) {
		    return value.subtract(new BigDecimal(integer)).multiply(ONE_BILLION).intValue();
		  }
	
	@Override
	public String toString() {
		
		
		return "time :" + this.getTime() +" price:"+this.getPrice() +" quantity:"+this.getQuantity()+"\n";

	}
}
