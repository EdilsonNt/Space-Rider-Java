package spaceRider;

public class SRMenu extends SRElements{

	public SRMenu(){
		super();
	}
	public SRMenu(String local, int x, int y, boolean isThread){
		super(local, x, y, isThread);
	}
	
	/**
	 * TODO Implements other options of menu
	 */
	@Override
	public void move() {
		setDy(2);
		super.move();
		if(getY() > 800) setVisible(false);
	}
}
