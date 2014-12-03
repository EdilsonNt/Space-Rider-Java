package spaceRider.GameEnvironment;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JPanel;

import spaceRider.Elements.SRCursor;
import spaceRider.Elements.SRElements;
import spaceRider.Elements.SRMenu;
import spaceRider.Elements.SRMissile;
import spaceRider.Elements.SRSpaceShip;

@SuppressWarnings("serial")
public class SRPlayField extends JPanel implements KeyListener, Runnable{

	private SRElements bckgA, bckgB;
	private SRMenu btStart, btRecords, btCredits, 
		logo, enemyMenu1, enemyMenu2, enemyMenu3;
	private SRCursor cursor;
	private SRSpaceShip spaceShip; 
	private List<SRMissile> missiles;
	private boolean isStarted;
	
	public SRPlayField() {
		super();
		
		isStarted = false;

		bckgA = new SRElements("res/SRSpace.jpg", 0, 0, false);
		bckgB = new SRElements("res/SRSpace.jpg", 0,-800, false);
		cursor = new SRCursor("res/SRCursor.png", 10, 555, false); 
		spaceShip = new SRSpaceShip("res/SRSpaceShip.gif", 365, 600, false);
		btStart = new SRMenu("res/SRIniciar.png", 0, 550, false);
		btRecords = new SRMenu("res/SRPontuacao.png", 0, 610, false);
		btCredits = new SRMenu("res/SRCreditos.png", 0, 670, false);
		logo = new SRMenu("res/SRLogo.png", 90, 325, false);
		
		enemyMenu1 = new SRMenu("res/SREnemy1.gif", 345, 175, false);
		enemyMenu2 = new SRMenu("res/SREnemy1.gif", 375, 135, false);
		enemyMenu3 = new SRMenu("res/SREnemy1.gif", 405, 175, false);
 		
		missiles = spaceShip.getMissiles();

		bckgA.setDy(2);
		bckgB.setDy(2);
		addKeyListener(this);
		setDoubleBuffered(true);
		setFocusable(true);
		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g){
		super.paint(g);
		g.drawImage( isVisibleToDraw(bckgA), bckgA.getX(), bckgA.getY(), 800, 800, null);
		g.drawImage( isVisibleToDraw(bckgB), bckgB.getX(), bckgB.getY(), 800, 800, null);
		
		for (int i = 0; i < missiles.size(); i++) {
			SRMissile tiroAux = missiles.get(i);
			if(tiroAux.isVisible()) {
				g.drawImage(tiroAux.getImage(), tiroAux.getX(), tiroAux.getY(), 7, 13, this);
			}else{
				missiles.remove(i);
			}
		}
		
		g.drawImage( isVisibleToDraw(enemyMenu1), enemyMenu1.getX(), enemyMenu1.getY(), this);
		g.drawImage( isVisibleToDraw(enemyMenu2), enemyMenu2.getX(), enemyMenu2.getY(), this);
		g.drawImage( isVisibleToDraw(enemyMenu3), enemyMenu3.getX(), enemyMenu3.getY(), this);
		g.drawImage( isVisibleToDraw(logo), logo.getX(), logo.getY(), this);
		g.drawImage( isVisibleToDraw(spaceShip), spaceShip.getX(), spaceShip.getY(), this);
		g.drawImage( isVisibleToDraw(btStart), btStart.getX(), btStart.getY(), this);
		g.drawImage( isVisibleToDraw(btRecords), btRecords.getX(), btRecords.getY(), this);
		g.drawImage( isVisibleToDraw(btCredits), btCredits.getX(), btCredits.getY(), this);
		g.drawImage( isVisibleToDraw(cursor), cursor.getX(), cursor.getY(), this);
	}

	public void iniciarJogo(){
		logo.move();
		btStart.move();
		btRecords.move();
		btCredits.move();
		enemyMenu1.move();
		enemyMenu2.move();
		enemyMenu3.move();
		bckgA.move();
		bckgB.move();
		
		if(!logo.isVisible() && !btStart.isVisible() && !btRecords.isVisible() && !btCredits.isVisible() && !enemyMenu1.isVisible() && !enemyMenu2.isVisible() && !enemyMenu3.isVisible())
			isStarted = true;
	}
	
	public Image isVisibleToDraw(SRElements obj){
		Image img = null;
		if(obj.isVisible()){
			img = obj.getImage();
		}
		return img;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(9);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!isStarted) {
				if(cursor.isStarted && cursor.getMenu() == 1) {
					iniciarJogo();
				}
			}else{
				missiles = spaceShip.getMissiles();
				for (int i = 0; i < missiles.size(); i++) {
					SRMissile tiroAux = missiles.get(i);
					tiroAux.move();
				}
				spaceShip.move();
				bckgA.move();
				bckgB.move();
				
				if(bckgA.getY() > 799) bckgA.setY(-800);
				if(bckgB.getY() > 799) bckgB.setY(-800);
			}
			
			repaint();
		}
	}
	@Override
	public void keyPressed(KeyEvent tecla) {
		if(isStarted) spaceShip.keyPressed(tecla);
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		if(isStarted) spaceShip.keyReleased(tecla);
		if(!isStarted) cursor.keyReleased(tecla);
	}
	@Override
	public void keyTyped(KeyEvent tecla) {}
}
