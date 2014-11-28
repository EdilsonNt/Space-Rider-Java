package spaceRider;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SRNave extends SRImagem{

	private List<SRTiro> tiros;
	
	public SRNave(String local, int x, int y) {
		super(local, x, y);
		tiros = new ArrayList<>();
	}
	
	public void atirar(){
		//TODO implementar atributo para definir de onde o 
		//TODO tiro vai ser lançado a partir do tamanho da nave
		tiros.add(new SRTiro(getX()		, getY() + 44));
		tiros.add(new SRTiro(getX() + 44, getY() + 44));
	}
	
	public List<SRTiro> getTiros() {
		return tiros;
	}

	@Override
	public void mover() {
		super.mover();

		if( getX() <   5 ) 	setX(5);
		if( getX() > 740 ) 	setX(740);
		if( getY() < 400 )	setY(400);
		if( getY() > 655 )	setY(655);
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		int teclaCodigo = tecla.getKeyCode();
		if( teclaCodigo == KeyEvent.VK_UP)		setDy(-5);
		if( teclaCodigo == KeyEvent.VK_DOWN)	setDy(5);
		if( teclaCodigo == KeyEvent.VK_LEFT)	setDx(-5);
		if( teclaCodigo == KeyEvent.VK_RIGHT)	setDx(5);
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		int teclaCodigo = tecla.getKeyCode();
		if( teclaCodigo == KeyEvent.VK_UP)		setDy(0);
		if( teclaCodigo == KeyEvent.VK_DOWN)	setDy(0);			
		if( teclaCodigo == KeyEvent.VK_LEFT)	setDx(0);
		if( teclaCodigo == KeyEvent.VK_RIGHT)	setDx(0);
		if( teclaCodigo == KeyEvent.VK_SPACE)	atirar();
	}
}
