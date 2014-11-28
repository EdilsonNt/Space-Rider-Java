package spaceRider;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class SRImagem {

	private int x, y, dx, dy;
	private boolean isVisivel;
	private String local;
	private Image imagem;
	
	public SRImagem(String local, int x, int y){
		setLocal(local);
		setX(x);
		setY(y);
		setVisivel(true);
	}
	
	public void mover(){
		setX(getX() + getDx());
		setY(getY() + getDy());
	}
	
	public void keyPressed(KeyEvent tecla) {}
	
	public void keyReleased(KeyEvent tecla) {}

	//Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getLocal() {
		return local;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	//Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setLocal(String local) {
		this.local = local;
		imagem = new ImageIcon(local).getImage();
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

}
