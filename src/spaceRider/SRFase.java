package spaceRider;

import java.awt.Graphics;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SRFase extends JPanel implements KeyListener, ActionListener{

	private SRElements bckgA, bckgB;
	private SRMenu btIniciar, btPontuacao, btCreditos, 
		logo, naveMenu1, naveMenu2, naveMenu3;
	private SRCursor cursor;
	private SRNave nave; 
	private Timer timer;
	private List<SRTiro> tiros;
	private boolean isIniciar;
	
	public SRFase() {
		super();
		
		isIniciar = false;
		timer = new Timer(7, this);
		
		bckgA = new SRElements("res/SRSpaco.jpg", 0, 0, false);
		bckgB = new SRElements("res/SRSpaco.jpg", 0,-800, false);
		cursor = new SRCursor("res/SRCursor.png", 10, 555, false); 
		nave = new SRNave("res/SRNave.gif", 365, 600, false);
		btIniciar = new SRMenu("res/SRIniciar.png", 0, 550, false);
		btPontuacao = new SRMenu("res/SRPontuacao.png", 0, 610, false);
		btCreditos = new SRMenu("res/SRCreditos.png", 0, 670, false);
		logo = new SRMenu("res/SRLogo.png", 90, 325, false);
		naveMenu2 = new SRMenu("res/SRInimigo1.gif", 375, 135, false);
		naveMenu1 = new SRMenu("res/SRInimigo1.gif", 345, 175, false);
		naveMenu3 = new SRMenu("res/SRInimigo1.gif", 405, 175, false);
 		
		tiros = nave.getTiros();

		timer.start();
		bckgA.setDy(1);
		bckgB.setDy(1);
		addKeyListener(this);
		setDoubleBuffered(true);
		setFocusable(true);
	}

	public void paint(Graphics g){
		g.drawImage(	bckgA.getImage(), 		bckgA.getX(), 		bckgA.getY(), 800, 800, null);
		g.drawImage(	bckgB.getImage(), 		bckgB.getX(), 		bckgB.getY(), 800, 800, null);
		
		for (int i = 0; i < tiros.size(); i++) {
			SRTiro tiroAux = tiros.get(i);
			if(tiroAux.isVisible()) {
				g.drawImage(tiroAux.getImage(), tiroAux.getX(), tiroAux.getY(), 10, 20, this);
			}else{
				tiros.remove(i);
			}
		}
		
		if(naveMenu1.isVisible()) 	g.drawImage(	naveMenu1.getImage(), 		naveMenu1.getX(), 	naveMenu1.getY(), 	this);
		if(naveMenu2.isVisible()) 	g.drawImage(	naveMenu2.getImage(), 		naveMenu2.getX(), 	naveMenu2.getY(), 	this);
		if(naveMenu3.isVisible()) 	g.drawImage(	naveMenu3.getImage(), 		naveMenu3.getX(), 	naveMenu3.getY(), 	this);
		if(logo.isVisible()) 		g.drawImage(	logo.getImage(), 			logo.getX(), 		logo.getY(), 		this);
		if(nave.isVisible()) 		g.drawImage(	nave.getImage(), 			nave.getX(), 		nave.getY(), 		this);
		if(btIniciar.isVisible()) 	g.drawImage(	btIniciar.getImage(),		btIniciar.getX(), 	btIniciar.getY(), 	this);
		if(btPontuacao.isVisible()) g.drawImage(	btPontuacao.getImage(), 	btPontuacao.getX(), btPontuacao.getY(), this);
		if(btCreditos.isVisible()) 	g.drawImage(	btCreditos.getImage(), 	btCreditos.getX(), 	btCreditos.getY(), 	this);
		if(cursor.isVisible()) 	  	g.drawImage(	cursor.getImage(), 		cursor.getX(), 		cursor.getY(), 		this);

		g.dispose();
	}

	public void iniciarJogo(){
		logo.move();
		btIniciar.move();
		btPontuacao.move();
		btCreditos.move();
		naveMenu1.move();
		naveMenu2.move();
		naveMenu3.move();
		bckgA.move();
		bckgB.move();
		
		if(!logo.isVisible() && !btIniciar.isVisible() && !btPontuacao.isVisible() && !btCreditos.isVisible() && !naveMenu1.isVisible() && !naveMenu2.isVisible() && !naveMenu3.isVisible())
			isIniciar = true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!isIniciar) {
			if(cursor.isStarted && cursor.getMenu() == 1) {
				iniciarJogo();
			}
		}

		if(isIniciar) {
			tiros = nave.getTiros();
			for (int i = 0; i < tiros.size(); i++) {
				SRTiro tiroAux = tiros.get(i);
				tiroAux.move();
			}
			nave.move();
			bckgA.move();
			bckgB.move();
			
			if(bckgA.getY() > 799) bckgA.setY(-800);
			if(bckgB.getY() > 799) bckgB.setY(-800);
		}
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		if(isIniciar) nave.keyPressed(tecla);
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		if(isIniciar) nave.keyReleased(tecla);
		if(!isIniciar) cursor.keyReleased(tecla);
	}
	@Override
	public void keyTyped(KeyEvent tecla) {}

}
