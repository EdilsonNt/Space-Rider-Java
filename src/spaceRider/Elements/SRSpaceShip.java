package spaceRider.Elements;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SRSpaceShip extends SRElements{

	private List<SRMissile> missile;
	private final static int SPACESHIP_CENTER = 24;
	
	public SRSpaceShip(String local, int x, int y, boolean isThread) {
		super(local, x, y, isThread);
		missile = new ArrayList<>();
	}
	
	public void shoot(){
		missile.add(new SRMissile("res/SRShoot1.png", getX() + SPACESHIP_CENTER, getY(), false));
	}
	
	public List<SRMissile> getMissiles() {
		return missile;
	}

	@Override
	public void move() {
		super.move();

		if( getX() <   5 ) setX(  5);
		if( getX() > 735 ) setX(735);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode =  key.getKeyCode();
		if( keyCode == KeyEvent.VK_LEFT)  setDx(-5);
		if( keyCode == KeyEvent.VK_RIGHT) setDx( 5);
	}

	@Override
	public void keyReleased(KeyEvent key) {
		int keyCode =  key.getKeyCode();
		if( keyCode == KeyEvent.VK_LEFT)	setDx(0);
		if( keyCode == KeyEvent.VK_RIGHT)	setDx(0);
		if( keyCode == KeyEvent.VK_SPACE)	shoot( );
	}
}
