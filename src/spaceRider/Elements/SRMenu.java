package spaceRider.Elements;

public class SRMenu extends SRElement{

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
		setDy(3);
		super.move();
		if(getY() > 800) setVisible(false);
	}
}
