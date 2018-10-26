package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.Pack;

public class PackFactory implements IPackFactory {
	
	private static PackFactory packFactory;
	
	private Integer numberPurchased;
	private Integer numberOffered;
	
	public static PackFactory getPackType() {
		if(packFactory == null) {
			packFactory = new PackFactory();
			
		}
		
		return packFactory;
	}
	
	@Override
	public Pack fabrique() {
		Pack pack = new Pack();
		pack.setNumberPurchased(numberPurchased);
		pack.setNumberOffered(numberOffered);
		return pack;
	}

	@Override
	public IPackFactory setNumberPurchased(Integer numberPurchased) {
		this.numberPurchased = numberOffered;
		return this;
	}

	@Override
	public IPackFactory setNumberOffered(Integer numberOffered) {
		this.numberOffered = numberOffered;
		return this;
	}

}
