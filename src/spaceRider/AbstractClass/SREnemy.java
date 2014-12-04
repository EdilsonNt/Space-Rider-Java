package spaceRider.AbstractClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import spaceRider.Elements.SRSpaceShip;
import spaceRider.Enum.SRScreenPosition;

public abstract class SREnemy extends SRSpaceShip {

	private static final List<SRScreenPosition> SCREEN_POSITION = new ArrayList<SRScreenPosition>(Arrays.asList(SRScreenPosition.values()));
	
	public SREnemy() {
		setY(0);
		setVisible(true);
		setThread();
	}
	
	public static List<SRScreenPosition> getScreenPosition() {
		return SCREEN_POSITION;
	}
	
	@Override
	public void move() {
		setX(getX() + getDx());
		setY(getY() + getDy());
		
		if(getY() > 850 || getX() < -50 || getX() > 850) setVisible(false);
	}
	
	@Override
	public void run() {
		while(isVisible()){
			move();
		}
	}
}
