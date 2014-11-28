package spaceRider;

public class SRTiro extends SRElements{

	public SRTiro(String local, int x, int y, boolean isThread){
		super(local, x, y, isThread);
	}

	//TODO Implementar tipos de tiro: duplo, teleguiado e laser.
	@Override
	public void move() {
		setDy(-4);
		super.move();
		if(getY() < 0) setVisible(false);
	}
}
