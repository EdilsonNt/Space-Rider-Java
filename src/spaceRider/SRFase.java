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

	private SRImagem bckgA, bckgB;
	private SRMenu btIniciar, btPontuacao, btCreditos, logo, naveMenu1, naveMenu2, naveMenu3;
	private SRCursor cursor;
	private SRNave nave; 
	private Timer timer;
	private List<SRTiro> tiros;
	private boolean isIniciar;
	
	public SRFase() {
		super();
		
		isIniciar 		= false;
		timer 			= new Timer(7, this);
		bckgA 			= new SRImagem(	"res/SRSpaco.jpg", 		  0,   0);
		bckgB 			= new SRImagem(	"res/SRSpaco.jpg", 		  0,-800);
		cursor 			= new SRCursor( "res/SRCursor.png", 	 10, 555); 
		nave 			= new SRNave(	"res/SRNave.gif", 		365, 555);
		btIniciar 		= new SRMenu(	"res/SRIniciar.png", 	  0, 550);
		btPontuacao 	= new SRMenu(	"res/SRPontuacao.png", 	  0, 610);
		btCreditos 		= new SRMenu(	"res/SRCreditos.png", 	  0, 670);
		logo 			= new SRMenu(	"res/SRLogo.png", 		 90, 325);
		naveMenu2 		= new SRMenu(	"res/SRInimigo1.gif", 	375, 135);
		naveMenu1 		= new SRMenu(	"res/SRInimigo1.gif", 	345, 175);
		naveMenu3 		= new SRMenu(	"res/SRInimigo1.gif", 	405, 175);
 		tiros			= nave.getTiros();

		timer.start();
		bckgA.setDy(1);
		bckgB.setDy(1);
		addKeyListener(this);
		setDoubleBuffered(true);
		setFocusable(true);
	}

	public void paint(Graphics g){
		g.drawImage(	bckgA.getImagem(), 		bckgA.getX(), 		bckgA.getY(), 800, 800, null);
		g.drawImage(	bckgB.getImagem(), 		bckgB.getX(), 		bckgB.getY(), 800, 800, null);
		
		for (int i = 0; i < tiros.size(); i++) {
			SRTiro tiroAux = tiros.get(i);
			if(tiroAux.isVisivel()) {
				g.drawImage(tiroAux.getImagem(), tiroAux.getX(), tiroAux.getY(), 10, 20, this);
			}else{
				tiros.remove(i);
			}
		}
		
		if(naveMenu1.isVisivel()) 	g.drawImage(	naveMenu1.getImagem(), 		naveMenu1.getX(), 	naveMenu1.getY(), 	this);
		if(naveMenu2.isVisivel()) 	g.drawImage(	naveMenu2.getImagem(), 		naveMenu2.getX(), 	naveMenu2.getY(), 	this);
		if(naveMenu3.isVisivel()) 	g.drawImage(	naveMenu3.getImagem(), 		naveMenu3.getX(), 	naveMenu3.getY(), 	this);
		if(logo.isVisivel()) 		g.drawImage(	logo.getImagem(), 			logo.getX(), 		logo.getY(), 		this);
		if(nave.isVisivel()) 		g.drawImage(	nave.getImagem(), 			nave.getX(), 		nave.getY(), 		this);
		if(btIniciar.isVisivel()) 	g.drawImage(	btIniciar.getImagem(),		btIniciar.getX(), 	btIniciar.getY(), 	this);
		if(btPontuacao.isVisivel()) g.drawImage(	btPontuacao.getImagem(), 	btPontuacao.getX(), btPontuacao.getY(), this);
		if(btCreditos.isVisivel()) 	g.drawImage(	btCreditos.getImagem(), 	btCreditos.getX(), 	btCreditos.getY(), 	this);
		if(cursor.isVisivel()) 	  	g.drawImage(	cursor.getImagem(), 		cursor.getX(), 		cursor.getY(), 		this);

		g.dispose();
	}

	public void iniciarJogo(){
		logo.mover();
		btIniciar.mover();
		btPontuacao.mover();
		btCreditos.mover();
		naveMenu1.mover();
		naveMenu2.mover();
		naveMenu3.mover();
		bckgA.mover();
		bckgB.mover();
		
		if(!logo.isVisivel() && !btIniciar.isVisivel() && !btPontuacao.isVisivel() && !btCreditos.isVisivel() && !naveMenu1.isVisivel() && !naveMenu2.isVisivel() && !naveMenu3.isVisivel())
			isIniciar = true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!isIniciar) {
			cursor.mover();
			if(cursor.isIniciar && cursor.getMenu() == 1) {
				iniciarJogo();
			}
		}

		if(isIniciar) {
			tiros = nave.getTiros();
			for (int i = 0; i < tiros.size(); i++) {
				SRTiro tiroAux = tiros.get(i);
				tiroAux.mover();
			}
			nave.mover();
			bckgA.mover();
			bckgB.mover();
			
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
