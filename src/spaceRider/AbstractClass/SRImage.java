package spaceRider.AbstractClass;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class SRImage {

	private int x, y, dx, dy;
	private boolean isVisible;
	private String local;
	private Image image;
	
	public SRImage(){
		super();
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getLocal() {
		return local;
	}

	public Image getImage() {
		return image;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setLocal(String local) {
		this.local = local;
		image = new ImageIcon(local).getImage();
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
