package spaceRider.Elements;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SRSpaceShip extends SRElement{

	private List<SRMissile> missile;
	private final static int SPACESHIP_CENTER = 24;
	
	public SRSpaceShip(){
		super();
	}
	public SRSpaceShip(String local, int x, int y) {
		super(local, x, y);
		missile = new ArrayList<>();
	}
	
	public void shoot(){
		missile.add(new SRMissile("res/SRShoot1.png", getX() + SPACESHIP_CENTER, getY()));
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
	
	@Override
	public void run() {
		while (isVisible()) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				move();
			}
			
		}
	}
}
