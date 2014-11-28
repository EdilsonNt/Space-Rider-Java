package spaceRider;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SRNave extends SRElements{

	private List<SRTiro> tiros;
	
	public SRNave(String local, int x, int y, boolean isThread) {
		super(local, x, y, isThread);
		tiros = new ArrayList<>();
	}
	
	public void atirar(){
		//TODO implementar atributo para definir de onde o 
		//TODO tiro vai ser lançado a partir do tamanho da nave
		tiros.add(new SRTiro("res/SRTiro1.png", getX(), getY() + 44, false));
		tiros.add(new SRTiro("res/SRTiro1.png", getX() + 44, getY() + 44, false));
	}
	
	public List<SRTiro> getTiros() {
		return tiros;
	}

	@Override
	public void move() {
		super.move();

		if( getX() <   5 ) 	setX(5);
		if( getX() > 735 ) 	setX(735);
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		int teclaCodigo = tecla.getKeyCode();
		if( teclaCodigo == KeyEvent.VK_LEFT)	setDx(-5);
		if( teclaCodigo == KeyEvent.VK_RIGHT)	setDx(5);
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		int teclaCodigo = tecla.getKeyCode();
		if( teclaCodigo == KeyEvent.VK_LEFT)	setDx(0);
		if( teclaCodigo == KeyEvent.VK_RIGHT)	setDx(0);
		if( teclaCodigo == KeyEvent.VK_SPACE)	atirar();
	}
}
