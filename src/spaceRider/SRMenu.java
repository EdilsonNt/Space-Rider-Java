package spaceRider;

public class SRMenu extends SRImagem{

	public SRMenu(String local, int x, int y){
		super(local, x, y);
	}
	
	//TODO Implementar as outras opcoes do menu
	@Override
	public void mover() {
		setDy(2);
		super.mover();
		int y = getY();
		if( y > 800 || y < 0) setVisivel(false);
	}

}
