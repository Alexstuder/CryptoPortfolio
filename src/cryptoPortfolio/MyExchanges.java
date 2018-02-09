package cryptoPortfolio;

import java.util.ArrayList;

import cryptoPortfolio.exchange.Exchange;
import cryptoPortfolio.exchange.liveCoin.LiveCoin;

public class MyExchanges {
	
	private ArrayList<Exchange> allExchanges = new ArrayList<Exchange>();
	
	public MyExchanges() {
		getExchanges();
	}
	
	public ArrayList<Exchange> getAllExchanges() {
		return allExchanges;
	}

	public void getExchanges(){
		
		LiveCoin liveCoin = new LiveCoin();
		allExchanges.add(liveCoin);
	}
	
	
	public void listAllExchanges() {
		
		for (Exchange exchange : allExchanges) {
			System.out.println(exchange.getName());
		}
		
	}

}
