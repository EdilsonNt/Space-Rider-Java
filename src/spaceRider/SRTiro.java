package spaceRider;

public class SRTiro extends SRImagem{

	public SRTiro(int x, int y){
		super("res/SRTiro1.png", x, y);
	}

	//TODO Implementar tipos de tiro: duplo, teleguiado e laser.
	@Override
	public void mover() {
		setDy(-4);
		super.mover();
		if(getY() < 0) setVisivel(false);
	}
}
