package spaceRider.Elements;

import java.awt.event.KeyEvent;

import spaceRider.AbstractClass.SRImage;

/**
 * @author Edilson Nt
 * @since 28/11/2014
 */
public class SRElement extends SRImage implements Runnable{

	private boolean isThread = false;
	private Thread thread;
	
	public SRElement() {
		super();
	}
	
	public SRElement(String local, int x, int y, boolean isThread){
		this();
		setLocal(local);
		setX(x);
		setY(y);
		setVisible(true);
		thread = new Thread(this);
		setThread(isThread);
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
	
	public void setThread(boolean isThread) {
		this.isThread = isThread;
	}

	public void keyPressed(KeyEvent tecla) {}

	public void keyReleased(KeyEvent tecla) {}

	@Override
	public void run() {

	}
}
