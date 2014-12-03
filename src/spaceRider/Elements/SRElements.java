package spaceRider.Elements;

import java.awt.event.KeyEvent;

import spaceRider.AbstractClass.SRImage;

/**
 * @author Edilson Nt
 * @since 28/11/2014
 */
public class SRElements extends SRImage implements Runnable{

	private boolean isThread = false;
	public SRElements() {
		super();
	}
	
	public SRElements(String local, int x, int y, boolean isThread){
		this();
		setLocal(local);
		setX(x);
		setY(y);
		setVisible(true);
		startThread();
	}

	public void move(){
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	public void startThread(){
		if(isThread){
			Thread thread = new Thread(this);
			thread.start();
		}
	}
	
	public void keyPressed(KeyEvent tecla) {}

	public void keyReleased(KeyEvent tecla) {}

	@Override
	public void run() {

	}
}
