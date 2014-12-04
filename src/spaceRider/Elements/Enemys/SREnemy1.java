package spaceRider.Elements.Enemys;

import spaceRider.AbstractClass.SREnemy;

/**
 * Generate 6 enemys with defined X that only move Y to 800
 */
public class SREnemy1 extends SREnemy{
	
	public SREnemy1(){
		super();
		setLocal("res/SREnemy1.gif");
		setParty();
	}
	
	@Override
	public void setParty() {
		
	}
}
