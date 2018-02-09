package cryptoPortfolio.portfolio;

import java.text.ParseException;

import cryptoPortfolio.exchange.MyExchanges;
import cryptoPortfolio.wallet.MyWallets;

public class MyPortfolio {

	public static void main(String[] args) throws ParseException {
		
		System.out.println("**********  Start MyPortfolio *************");
		
		//getExchange
		System.out.println("**********  Get Exchanges *************");
		MyExchanges myExchanges = new MyExchanges();
		myExchanges.listAllExchanges();
		
		
		// get MyWallets
		System.out.println("**********  Get Wallets *************");
		MyWallets myWallets = new MyWallets();
        myWallets.listAllWallets();
        
        for (Position position : myWallets.getRates(myExchanges)) {

        	System.out.println(position.toString());
		}
		System.out.println("**********  End MyPortfolio *************");
	}

}
