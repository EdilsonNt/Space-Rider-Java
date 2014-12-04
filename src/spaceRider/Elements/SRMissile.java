package spaceRider.Elements;

public class SRMissile extends SRElement{

	public SRMissile(String local, int x, int y){
		super(local, x, y);
	}

	@Override
	public void move() {
		setDy(-4);
		super.move();
		if(getY() < 0) setVisible(false);
	}
}
