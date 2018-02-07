package cryptoPortfolio.wallet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public interface Wallet {
	
	
	
	
	public void setName(String name);
	public void addpositionToList(Position position);

	public String getName();
	public ArrayList<Position> getCryptoPositions();
	
	
	// Methods


}
