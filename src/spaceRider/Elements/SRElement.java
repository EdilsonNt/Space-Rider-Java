package spaceRider.Elements;

import java.awt.event.KeyEvent;

import spaceRider.AbstractClass.SRImage;

/**
 * @author Edilson Nt
 * @since 28/11/2014
 */
public class SRElement extends SRImage implements Runnable{

	private Thread thread;
	
	public SRElement() {
		super();
	}
	
	public SRElement(String local, int x, int y){
		this();
		setLocal(local);
		setX(x);
		setY(y);
		setVisible(true);
		setThread();
	}

	public void move(){
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	public Thread getThread() {
		return thread;
	}
	
	public void setThread() {
		thread = new Thread(this);
	}
	
	public void keyPressed(KeyEvent tecla) {}

	public void keyReleased(KeyEvent tecla) {}

	@Override
	public void run() {

	}
}
