package cryptoPortfolio.wallet;

import java.util.ArrayList;

public class MyEtherWallet implements Wallet {

	private String name;
	private ArrayList<Position> positionList = new ArrayList<Position>();
	
	
	
	@Override
	public void setName(String name) {
		this.name = name ;
		
	}
	@Override
	public void addpositionToList(Position position) {
		this.positionList.add(position);
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public ArrayList<Position> getCryptoPositions() {
		// TODO Auto-generated method stub
		return this.positionList;
	};







}
