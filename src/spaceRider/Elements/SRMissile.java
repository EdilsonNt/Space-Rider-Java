package spaceRider.Elements;

public class SRMissile extends SRElements{

	public SRMissile(String local, int x, int y, boolean isThread){
		super(local, x, y, isThread);
	}

	@Override
	public void move() {
		setDy(-4);
		super.move();
		if(getY() < 0) setVisible(false);
	}
}
