package spaceRider.AbstractClass;

import spaceRider.Elements.SRSpaceShip;

public abstract class SREnemy extends SRSpaceShip {

	public SREnemy() {
		setY(0);
		setVisible(true);
		setThread();
	}
	
	@Override
	public void move() {
		setX(getX() + getDx());
		setY(getY() + getDy());
	}
}
