package spaceRider.Elements.Enemies;

import spaceRider.AbstractClass.SREnemy;
import spaceRider.Enum.SREnemiesFile;

/**
 * Generate 6 enemies with defined X that only move Y to 800
 */
public class SREnemy1 extends SREnemy{
	
	public SREnemy1(){
		super();
		setLocal(SREnemiesFile.ENEMY_1.getSrc());
		setDy(2);
	}
	
	@Override
	public void move() {
		super.move();
		if(getY() > 400) setDy(4);
	}
}
