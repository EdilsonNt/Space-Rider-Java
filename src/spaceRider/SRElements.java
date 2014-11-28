package spaceRider;

import java.awt.event.KeyEvent;

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
		if(isThread) startThread();
	}

	public boolean isThread() {
		return isThread;
	}

	public void setThread(boolean isThread) {
		this.isThread = isThread;
	}

	public void move(){
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	public void startThread(){
		Thread t = new Thread(this);
		t.start();
	}
	
	public void keyPressed(KeyEvent tecla) {}

	public void keyReleased(KeyEvent tecla) {}

	@Override
	public void run() {

	}
}
