package spaceRider;

import java.awt.event.KeyEvent;

public class SRCursor extends SRImagem{
	
	private int menu = 1;
	public boolean isIniciar;
	
	public SRCursor(String local, int x, int y){
		super(local, x, y);
	}

	public void mover(int num) {
		menu += num;
		
		if(menu > 3) menu = 1;
		if(menu < 1) menu = 3;
	
		switch (menu) {
		case 1:
			setY(555); //Iniciar
			break;
		case 2:
			setY(615); //Pontuação
			break;
		case 3:
			setY(675); //Créditos
			break;
		default:
			break;
		}
	}


	public int getMenu() {
		return menu;
	}
	
	public boolean isIniciar() {
		return isIniciar;
	}

	public void setIniciar(boolean isIniciar) {
		this.isIniciar = isIniciar;
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		int teclaCodigo = tecla.getKeyCode();
		if( teclaCodigo == KeyEvent.VK_UP) 		mover(-1);		
		if( teclaCodigo == KeyEvent.VK_DOWN) 	mover( 1);
		if( teclaCodigo == KeyEvent.VK_SPACE) {	
			setIniciar(true);
			setVisivel(false);
		}
	}
}
