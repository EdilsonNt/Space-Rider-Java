package spaceRider.AbstractClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import spaceRider.Elements.SRSpaceShip;
import spaceRider.Enum.SRScreenPosition;

public abstract class SREnemy extends SRSpaceShip {

	private List<SREnemy> party;
	private List<SRScreenPosition> screenPosition;
	
	public SREnemy() {
		party = new ArrayList<SREnemy>();
		screenPosition = new ArrayList<SRScreenPosition>(Arrays.asList(SRScreenPosition.values()));
		setY(0);
		setVisible(true);
		setThread();
	}
	
	public List<SRScreenPosition> getScreenPosition() {
		return screenPosition;
	}

	public List<SREnemy> getParty() {
		return party;
	}
	
	public abstract void setParty();
	
	@Override
	public void move() {
		setX(getX() + getDx());
		setY(getY() + getDy());
		
		if(getY() > 850 || getX() < -50 || getX() > 850) setVisible(false);
	}
}
