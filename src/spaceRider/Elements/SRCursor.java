package spaceRider.Elements;

import java.awt.event.KeyEvent;

public class SRCursor extends SRElement{
	
	private int menu = 1;
	public boolean isStarted;
	
	public SRCursor(){
		super();
	}
	
	public SRCursor(String local, int x, int y){
		super(local, x, y);
	}

	/**
	 * @param menu is number of menu selected
	 * Receive menu and set Y of cursor
	 */
	public void move(int menu) {
		this.menu += menu;
		if(this.menu > 3) this.menu = 1;
		if(this.menu < 1) this.menu = 3;
		
		switch (this.menu) {
		case 1: //Start
			setY(555); 
			break;
		case 2: //Records
			setY(615);
			break;
		case 3: //Credits
			setY(675); 
			break;
		default:
			break;
		}
	}

	public int getMenu() {
		return menu;
	}
	
	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	@Override
	public void keyReleased(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if( keyCode == KeyEvent.VK_UP) move(-1);		
		if( keyCode == KeyEvent.VK_DOWN) move( 1);
		if( keyCode == KeyEvent.VK_ENTER) {	
			setStarted(true);
			setVisible(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent tecla) {}
}